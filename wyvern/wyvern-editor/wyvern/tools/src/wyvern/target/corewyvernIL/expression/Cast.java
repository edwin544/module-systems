package wyvern.target.corewyvernIL.expression;

import java.io.IOException;
import java.util.Set;

import wyvern.target.corewyvernIL.astvisitor.ASTVisitor;
import wyvern.target.corewyvernIL.effects.EffectAccumulator;
import wyvern.target.corewyvernIL.support.EvalContext;
import wyvern.target.corewyvernIL.support.FailureReason;
import wyvern.target.corewyvernIL.support.TypeContext;
import wyvern.target.corewyvernIL.type.ValueType;
import wyvern.tools.errors.ErrorMessage;
import wyvern.tools.errors.ToolError;

public class Cast extends Expression {
    private IExpr toCastExpr;

    public Cast(IExpr toCastExpr, ValueType exprType) {
        super(exprType);
        this.toCastExpr = toCastExpr;
    }

    public IExpr getToCastExpr() {
        return toCastExpr;
    }

    @Override
    public ValueType typeCheck(TypeContext ctx, EffectAccumulator effectAccumulator) {
        toCastExpr.typeCheck(ctx, effectAccumulator);
        return getType().getCanonicalType(ctx);
    }

    @Override
    public <S, T> T acceptVisitor(ASTVisitor<S, T> emitILVisitor, S state) {
        return emitILVisitor.visit(state, this);
    }

    @Override
    public Value interpret(EvalContext ctx) {
        Value value = getToCastExpr().interpret(ctx);
        ValueType actualType = value.typeCheck(ctx, null);
        ValueType goalType = getType();
        FailureReason r = new FailureReason();
        if (!actualType.isSubtypeOf(goalType, ctx, r)) {
            ToolError.reportError(ErrorMessage.NOT_SUBTYPE, getLocation(), actualType.toString(), goalType.toString(), r.getReason());
        }
        return value;
    }

    @Override
    public Set<String> getFreeVariables() {
        return toCastExpr.getFreeVariables();
    }

    @Override
    public void doPrettyPrint(Appendable dest, String indent) throws IOException {
        dest.append("((");
        getType().doPrettyPrint(dest, "");
        dest.append(") ");
        toCastExpr.doPrettyPrint(dest, "");
        dest.append(")");
    }
}
