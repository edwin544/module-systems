/*
 * Built at Mon Jul 04 18:11:07 NZST 2022
 * by Copper version 0.7.1,
 *      revision unknown,
 *      build 20140605-2206
 */
package wyvern.tools.lexing;

import edu.umn.cs.melt.copper.runtime.logging.CopperParserException;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import wyvern.tools.errors.ErrorMessage;
import wyvern.tools.errors.FileLocation;
import wyvern.tools.errors.ToolError;
import wyvern.tools.parsing.coreparser.Token;
import wyvern.tools.parsing.coreparser.WyvernParserConstants;

import static wyvern.tools.parsing.coreparser.WyvernParserConstants.*;



public class WyvernLexer extends edu.umn.cs.melt.copper.runtime.engines.single.SingleDFAEngine<List< Token >,edu.umn.cs.melt.copper.runtime.logging.CopperParserException>
{
    protected String formatError(String error)
    {
    	   String location = "";
        location += "line " + virtualLocation.getLine() + ", column " + virtualLocation.getColumn();
        if(currentState.pos.getFileName().length() > 40) location += "\n         ";
        location += " in file " + virtualLocation.getFileName();
        location += "\n         (parser state: " + currentState.statenum + "; real character index: " + currentState.pos.getPos() + ")";
        return "Error at " + location + ":\n  " + error;
    }
    protected void reportError(String message)
    throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
    {
        throw new edu.umn.cs.melt.copper.runtime.logging.CopperParserException(message);
    }
    protected void reportSyntaxError()
    throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
    {
    java.util.ArrayList<String> expectedTerminalsReal = bitVecToRealStringList(getShiftableSets()[currentState.statenum]);
    java.util.ArrayList<String> expectedTerminalsDisplay = bitVecToDisplayStringList(getShiftableSets()[currentState.statenum]);
    java.util.ArrayList<String> matchedTerminalsReal = bitVecToRealStringList(disjointMatch.terms);
    java.util.ArrayList<String> matchedTerminalsDisplay = bitVecToDisplayStringList(disjointMatch.terms);
    throw new edu.umn.cs.melt.copper.runtime.logging.CopperSyntaxError(virtualLocation,currentState.pos,currentState.statenum,expectedTerminalsReal,expectedTerminalsDisplay,matchedTerminalsReal,matchedTerminalsDisplay);
    }
    public static enum Terminals implements edu.umn.cs.melt.copper.runtime.engines.CopperTerminalEnum
    {
        abstractKwd_t(1),
        and_t(2),
        arrow_t(3),
        asKwd_t(4),
        assertKwd_t(5),
        bar_t(6),
        booleanLit_t(7),
        booleanand_t(8),
        booleannot_t(9),
        booleanor_t(10),
        cCurly_t(11),
        cSquareBracket_t(12),
        caseKwd_t(13),
        character_t(14),
        classKwd_t(15),
        closeParen_t(16),
        colon_t(17),
        comma_t(18),
        comment_t(19),
        comprisesKwd_t(20),
        continue_line_t(21),
        dash_t(22),
        datatypeKwd_t(23),
        decimalInteger_t(24),
        defKwd_t(25),
        defaultKwd_t(26),
        divide_t(27),
        dot_t(28),
        dslLine_t(29),
        dsl_indent_t(30),
        effectKwd_t(31),
        equals_t(32),
        equalsequals_t(33),
        extendsKwd_t(34),
        floatingPoint_t(35),
        fn_newline_t(36),
        forwardKwd_t(37),
        ge_t(38),
        gt_t(39),
        identifier_t(40),
        iindent_t(41),
        importKwd_t(42),
        indent_t(43),
        inewline_t(44),
        instantiateKwd_t(45),
        le_t(46),
        liftedKwd_t(47),
        lt_t(48),
        matchKwd_t(49),
        metadataKwd_t(50),
        moduleKwd_t(51),
        mult_t(52),
        multi_comment_t(53),
        newKwd_t(54),
        newline_t(55),
        noneKwd_t(56),
        notCurly_t(57),
        notequals_t(58),
        oCurly_t(59),
        oSquareBracket_t(60),
        objtypeKwd_t(61),
        ofKwd_t(62),
        openParen_t(63),
        plus_t(64),
        pound_t(65),
        question_t(66),
        rationalLit_t(67),
        recurKwd_t(68),
        remainder_t(69),
        requireKwd_t(70),
        resourceKwd_t(71),
        shortString_t(72),
        taggedKwd_t(73),
        tarrow_t(74),
        tilde_t(75),
        toKwd_t(76),
        typeKwd_t(77),
        valKwd_t(78),
        varKwd_t(79),
        whitespace_t(80);

        private final int num;
        Terminals(int num) { this.num = num; }
        public int num() { return num; }
    }

    public void pushToken(Terminals t,String lexeme)
    {
        java.util.BitSet ts = new java.util.BitSet();
        ts.set(t.num());
        tokenBuffer.offer(new edu.umn.cs.melt.copper.runtime.engines.single.scanner.SingleDFAMatchData(ts,currentState.pos,currentState.pos,lexeme,new java.util.LinkedList<edu.umn.cs.melt.copper.runtime.engines.single.scanner.SingleDFAMatchData>()));
    }
    public void setupEngine()
    {
    }
    public int transition(int state,char ch)
    {
         return delta[state][cmap[ch]];
    }
    public class Semantics extends edu.umn.cs.melt.copper.runtime.engines.single.semantics.SingleDFASemanticActionContainer<edu.umn.cs.melt.copper.runtime.logging.CopperParserException>
    {

        public Semantics()
        throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            runInit();
        }

        public void error(edu.umn.cs.melt.copper.runtime.io.InputPosition pos,java.lang.String message)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            reportError("Error at " + pos.toString() + ":\n  " + message);
        }

        public void runDefaultTermAction()
        throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
        }
        public void runDefaultProdAction()
        throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
        }
        public void runInit()
        throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            
	// start with the baseline indentation level
	indents.push("");
        }
        public java.lang.Object runSemanticAction(edu.umn.cs.melt.copper.runtime.io.InputPosition _pos,java.lang.Object[] _children,int _prod)
        throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            this._pos = _pos;
            this._children = _children;
            this._prod = _prod;
            this._specialAttributes = new edu.umn.cs.melt.copper.runtime.engines.semantics.SpecialParserAttributes(virtualLocation);
            java.lang.Object RESULT = null;
            switch(_prod)
            {
            case 103:
                RESULT = runSemanticAction_103();
                break;
            case 104:
                RESULT = runSemanticAction_104();
                break;
            case 105:
                RESULT = runSemanticAction_105();
                break;
            case 106:
                RESULT = runSemanticAction_106();
                break;
            case 107:
                RESULT = runSemanticAction_107();
                break;
            case 108:
                RESULT = runSemanticAction_108();
                break;
            case 109:
                RESULT = runSemanticAction_109();
                break;
            case 110:
                RESULT = runSemanticAction_110();
                break;
            case 111:
                RESULT = runSemanticAction_111();
                break;
            case 112:
                RESULT = runSemanticAction_112();
                break;
            case 113:
                RESULT = runSemanticAction_113();
                break;
            case 114:
                RESULT = runSemanticAction_114();
                break;
            case 115:
                RESULT = runSemanticAction_115();
                break;
            case 116:
                RESULT = runSemanticAction_116();
                break;
            case 117:
                RESULT = runSemanticAction_117();
                break;
            case 118:
                RESULT = runSemanticAction_118();
                break;
            case 119:
                RESULT = runSemanticAction_119();
                break;
            case 120:
                RESULT = runSemanticAction_120();
                break;
            case 121:
                RESULT = runSemanticAction_121();
                break;
            case 122:
                RESULT = runSemanticAction_122();
                break;
            case 123:
                RESULT = runSemanticAction_123();
                break;
            case 124:
                RESULT = runSemanticAction_124();
                break;
            case 125:
                RESULT = runSemanticAction_125();
                break;
            case 126:
                RESULT = runSemanticAction_126();
                break;
            case 127:
                RESULT = runSemanticAction_127();
                break;
            case 128:
                RESULT = runSemanticAction_128();
                break;
            case 129:
                RESULT = runSemanticAction_129();
                break;
            case 130:
                RESULT = runSemanticAction_130();
                break;
            case 131:
                RESULT = runSemanticAction_131();
                break;
            case 132:
                RESULT = runSemanticAction_132();
                break;
            case 133:
                RESULT = runSemanticAction_133();
                break;
            case 134:
                RESULT = runSemanticAction_134();
                break;
            case 135:
                RESULT = runSemanticAction_135();
                break;
            case 136:
                RESULT = runSemanticAction_136();
                break;
            case 137:
                RESULT = runSemanticAction_137();
                break;
            case 138:
                RESULT = runSemanticAction_138();
                break;
            case 139:
                RESULT = runSemanticAction_139();
                break;
            case 140:
                RESULT = runSemanticAction_140();
                break;
            case 141:
                RESULT = runSemanticAction_141();
                break;
            case 142:
                RESULT = runSemanticAction_142();
                break;
            case 143:
                RESULT = runSemanticAction_143();
                break;
            case 144:
                RESULT = runSemanticAction_144();
                break;
            case 145:
                RESULT = runSemanticAction_145();
                break;
            case 146:
                RESULT = runSemanticAction_146();
                break;
            case 147:
                RESULT = runSemanticAction_147();
                break;
            case 148:
                RESULT = runSemanticAction_148();
                break;
            case 149:
                RESULT = runSemanticAction_149();
                break;
            case 150:
                RESULT = runSemanticAction_150();
                break;
            case 151:
                RESULT = runSemanticAction_151();
                break;
            case 152:
                RESULT = runSemanticAction_152();
                break;
            case 153:
                RESULT = runSemanticAction_153();
                break;
            case 154:
                RESULT = runSemanticAction_154();
                break;
            case 155:
                RESULT = runSemanticAction_155();
                break;
            case 156:
                RESULT = runSemanticAction_156();
                break;
            case 157:
                RESULT = runSemanticAction_157();
                break;
            case 158:
                RESULT = runSemanticAction_158();
                break;
            case 159:
                RESULT = runSemanticAction_159();
                break;
            case 160:
                RESULT = runSemanticAction_160();
                break;
            case 161:
                RESULT = runSemanticAction_161();
                break;
            case 162:
                RESULT = runSemanticAction_162();
                break;
            case 163:
                RESULT = runSemanticAction_163();
                break;
            case 164:
                RESULT = runSemanticAction_164();
                break;
            case 165:
                RESULT = runSemanticAction_165();
                break;
            case 166:
                RESULT = runSemanticAction_166();
                break;
            case 167:
                RESULT = runSemanticAction_167();
                break;
            case 168:
                RESULT = runSemanticAction_168();
                break;
            case 169:
                RESULT = runSemanticAction_169();
                break;
            case 170:
                RESULT = runSemanticAction_170();
                break;
            case 171:
                RESULT = runSemanticAction_171();
                break;
            case 172:
                RESULT = runSemanticAction_172();
                break;
            case 173:
                RESULT = runSemanticAction_173();
                break;
            case 174:
                RESULT = runSemanticAction_174();
                break;
            case 175:
                RESULT = runSemanticAction_175();
                break;
            case 176:
                RESULT = runSemanticAction_176();
                break;
            case 177:
                RESULT = runSemanticAction_177();
                break;
            case 178:
                RESULT = runSemanticAction_178();
                break;
            case 179:
                RESULT = runSemanticAction_179();
                break;
            case 180:
                RESULT = runSemanticAction_180();
                break;
            case 181:
                RESULT = runSemanticAction_181();
                break;
            case 182:
                RESULT = runSemanticAction_182();
                break;
            case 183:
                RESULT = runSemanticAction_183();
                break;
            case 184:
                RESULT = runSemanticAction_184();
                break;
            case 185:
                RESULT = runSemanticAction_185();
                break;
            case 186:
                RESULT = runSemanticAction_186();
                break;
            case 187:
                RESULT = runSemanticAction_187();
                break;
            case 188:
                RESULT = runSemanticAction_188();
                break;
            case 189:
                RESULT = runSemanticAction_189();
                break;
            case 190:
                RESULT = runSemanticAction_190();
                break;
            case 191:
                RESULT = runSemanticAction_191();
                break;
            case 192:
                RESULT = runSemanticAction_192();
                break;
            case 193:
                RESULT = runSemanticAction_193();
                break;
            case 194:
                RESULT = runSemanticAction_194();
                break;
            case 195:
                RESULT = runSemanticAction_195();
                break;
            case 196:
                RESULT = runSemanticAction_196();
                break;
            case 197:
                RESULT = runSemanticAction_197();
                break;
            case 198:
                RESULT = runSemanticAction_198();
                break;
            case 199:
                RESULT = runSemanticAction_199();
                break;
            case 200:
                RESULT = runSemanticAction_200();
                break;
            case 201:
                RESULT = runSemanticAction_201();
                break;
            case 202:
                RESULT = runSemanticAction_202();
                break;
            case 203:
                RESULT = runSemanticAction_203();
                break;
            case 204:
                RESULT = runSemanticAction_204();
                break;
            default:
        runDefaultProdAction();
                 break;
            }
            return RESULT;
        }
        public java.lang.Object runSemanticAction(edu.umn.cs.melt.copper.runtime.io.InputPosition _pos,edu.umn.cs.melt.copper.runtime.engines.single.scanner.SingleDFAMatchData _terminal)
        throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            this._pos = _pos;
            this._terminal = _terminal;
            this._specialAttributes = new edu.umn.cs.melt.copper.runtime.engines.semantics.SpecialParserAttributes(virtualLocation);
            String lexeme = _terminal.lexeme;
            java.lang.Object RESULT = null;
            switch(_terminal.firstTerm)
            {
            case 1:
                RESULT = runSemanticAction_1(lexeme);
                break;
            case 2:
                RESULT = runSemanticAction_2(lexeme);
                break;
            case 3:
                RESULT = runSemanticAction_3(lexeme);
                break;
            case 4:
                RESULT = runSemanticAction_4(lexeme);
                break;
            case 5:
                RESULT = runSemanticAction_5(lexeme);
                break;
            case 6:
                RESULT = runSemanticAction_6(lexeme);
                break;
            case 7:
                RESULT = runSemanticAction_7(lexeme);
                break;
            case 8:
                RESULT = runSemanticAction_8(lexeme);
                break;
            case 9:
                RESULT = runSemanticAction_9(lexeme);
                break;
            case 10:
                RESULT = runSemanticAction_10(lexeme);
                break;
            case 11:
                RESULT = runSemanticAction_11(lexeme);
                break;
            case 12:
                RESULT = runSemanticAction_12(lexeme);
                break;
            case 14:
                RESULT = runSemanticAction_14(lexeme);
                break;
            case 15:
                RESULT = runSemanticAction_15(lexeme);
                break;
            case 16:
                RESULT = runSemanticAction_16(lexeme);
                break;
            case 17:
                RESULT = runSemanticAction_17(lexeme);
                break;
            case 18:
                RESULT = runSemanticAction_18(lexeme);
                break;
            case 19:
                RESULT = runSemanticAction_19(lexeme);
                break;
            case 20:
                RESULT = runSemanticAction_20(lexeme);
                break;
            case 21:
                RESULT = runSemanticAction_21(lexeme);
                break;
            case 22:
                RESULT = runSemanticAction_22(lexeme);
                break;
            case 23:
                RESULT = runSemanticAction_23(lexeme);
                break;
            case 24:
                RESULT = runSemanticAction_24(lexeme);
                break;
            case 25:
                RESULT = runSemanticAction_25(lexeme);
                break;
            case 26:
                RESULT = runSemanticAction_26(lexeme);
                break;
            case 27:
                RESULT = runSemanticAction_27(lexeme);
                break;
            case 28:
                RESULT = runSemanticAction_28(lexeme);
                break;
            case 29:
                RESULT = runSemanticAction_29(lexeme);
                break;
            case 30:
                RESULT = runSemanticAction_30(lexeme);
                break;
            case 31:
                RESULT = runSemanticAction_31(lexeme);
                break;
            case 32:
                RESULT = runSemanticAction_32(lexeme);
                break;
            case 33:
                RESULT = runSemanticAction_33(lexeme);
                break;
            case 34:
                RESULT = runSemanticAction_34(lexeme);
                break;
            case 35:
                RESULT = runSemanticAction_35(lexeme);
                break;
            case 36:
                RESULT = runSemanticAction_36(lexeme);
                break;
            case 37:
                RESULT = runSemanticAction_37(lexeme);
                break;
            case 38:
                RESULT = runSemanticAction_38(lexeme);
                break;
            case 39:
                RESULT = runSemanticAction_39(lexeme);
                break;
            case 40:
                RESULT = runSemanticAction_40(lexeme);
                break;
            case 41:
                RESULT = runSemanticAction_41(lexeme);
                break;
            case 42:
                RESULT = runSemanticAction_42(lexeme);
                break;
            case 43:
                RESULT = runSemanticAction_43(lexeme);
                break;
            case 44:
                RESULT = runSemanticAction_44(lexeme);
                break;
            case 45:
                RESULT = runSemanticAction_45(lexeme);
                break;
            case 46:
                RESULT = runSemanticAction_46(lexeme);
                break;
            case 47:
                RESULT = runSemanticAction_47(lexeme);
                break;
            case 48:
                RESULT = runSemanticAction_48(lexeme);
                break;
            case 49:
                RESULT = runSemanticAction_49(lexeme);
                break;
            case 50:
                RESULT = runSemanticAction_50(lexeme);
                break;
            case 51:
                RESULT = runSemanticAction_51(lexeme);
                break;
            case 52:
                RESULT = runSemanticAction_52(lexeme);
                break;
            case 53:
                RESULT = runSemanticAction_53(lexeme);
                break;
            case 54:
                RESULT = runSemanticAction_54(lexeme);
                break;
            case 55:
                RESULT = runSemanticAction_55(lexeme);
                break;
            case 56:
                RESULT = runSemanticAction_56(lexeme);
                break;
            case 57:
                RESULT = runSemanticAction_57(lexeme);
                break;
            case 58:
                RESULT = runSemanticAction_58(lexeme);
                break;
            case 59:
                RESULT = runSemanticAction_59(lexeme);
                break;
            case 60:
                RESULT = runSemanticAction_60(lexeme);
                break;
            case 63:
                RESULT = runSemanticAction_63(lexeme);
                break;
            case 64:
                RESULT = runSemanticAction_64(lexeme);
                break;
            case 65:
                RESULT = runSemanticAction_65(lexeme);
                break;
            case 66:
                RESULT = runSemanticAction_66(lexeme);
                break;
            case 67:
                RESULT = runSemanticAction_67(lexeme);
                break;
            case 68:
                RESULT = runSemanticAction_68(lexeme);
                break;
            case 69:
                RESULT = runSemanticAction_69(lexeme);
                break;
            case 70:
                RESULT = runSemanticAction_70(lexeme);
                break;
            case 71:
                RESULT = runSemanticAction_71(lexeme);
                break;
            case 72:
                RESULT = runSemanticAction_72(lexeme);
                break;
            case 73:
                RESULT = runSemanticAction_73(lexeme);
                break;
            case 74:
                RESULT = runSemanticAction_74(lexeme);
                break;
            case 75:
                RESULT = runSemanticAction_75(lexeme);
                break;
            case 76:
                RESULT = runSemanticAction_76(lexeme);
                break;
            case 77:
                RESULT = runSemanticAction_77(lexeme);
                break;
            case 78:
                RESULT = runSemanticAction_78(lexeme);
                break;
            case 79:
                RESULT = runSemanticAction_79(lexeme);
                break;
            case 80:
                RESULT = runSemanticAction_80(lexeme);
                break;
            default:
        runDefaultTermAction();
                 break;
            }
            return RESULT;
        }
        public List< Token > runSemanticAction_103()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > line = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = line; 
            return RESULT;
        }
        public List< Token > runSemanticAction_104()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > line = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = line; 
            return RESULT;
        }
        public List< Token > runSemanticAction_105()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_106()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > n = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = n; 
            return RESULT;
        }
        public List< Token > runSemanticAction_107()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token line = (Token) _children[1];
            List< Token > RESULT = null;
            
							RESULT = LexerUtils.makeList(t);
							RESULT.add(line);
							flagTokSet = false; // always reset this bool after each line
					
            return RESULT;
        }
        public List runSemanticAction_108()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List RESULT = null;
             RESULT = LexerUtils.makeList(n); flagTok = null; lastIndent = n; 
            return RESULT;
        }
        public List runSemanticAction_109()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            List list = (List) _children[0];
            @SuppressWarnings("unchecked") List< Token > n = (List< Token >) _children[1];
            List RESULT = null;
            
	                            	adjustEQARROW(n);
                                if (flagTok != null && flagTok.kind == EQARROW && !isEQARROWlast) {
                                    flagTok = null;
                                }
                                list.addAll(n); RESULT = list;
                            
            return RESULT;
        }
        public List< Token > runSemanticAction_110()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > line = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = line; 
            return RESULT;
        }
        public List< Token > runSemanticAction_111()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[0];
            @SuppressWarnings("unchecked") List< Token > line = (List< Token >) _children[1];
            List< Token > RESULT = null;
             p.addAll(line); RESULT = p; 
            return RESULT;
        }
        public List< Token > runSemanticAction_112()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            List list = (List) _children[0];
            Token n = (Token) _children[1];
            List< Token > RESULT = null;
            
						list.add(n);
						RESULT = LexerUtils.<WyvernParserConstants>adjustLogicalLine((LinkedList<Token>)list,
						                    virtualLocation.getFileName(), indents, WyvernParserConstants.class);
					    if (foundTilde) {
						    DSLNext = true;
						    foundTilde = false;
						}
					
            return RESULT;
        }
        public List< Token > runSemanticAction_113()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public java.lang.Object runSemanticAction_114()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            java.lang.Object idsl = (java.lang.Object) _children[1];
            java.lang.Object RESULT = null;
             RESULT = idsl; 
            return RESULT;
        }
        public java.lang.Object runSemanticAction_115()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            java.lang.Object str = (java.lang.Object) _children[0];
            java.lang.Object RESULT = null;
             RESULT = str; 
            return RESULT;
        }
        public java.lang.Object runSemanticAction_116()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            java.lang.Object str = (java.lang.Object) _children[0];
            java.lang.Object idsl = (java.lang.Object) _children[2];
            java.lang.Object stre = (java.lang.Object) _children[4];
            java.lang.Object RESULT = null;
             RESULT = str + "{" + idsl + "}" + stre; 
            return RESULT;
        }
        public java.lang.Object runSemanticAction_117()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            java.lang.Object RESULT = null;
             RESULT = ""; 
            return RESULT;
        }
        public Token runSemanticAction_118()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_119()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_120()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_121()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_122()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_123()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_124()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_125()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_126()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_127()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_128()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_129()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_130()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_131()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_132()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_133()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_134()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_135()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_136()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_137()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_138()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_139()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_140()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_141()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_142()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_143()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_144()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public List runSemanticAction_145()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List RESULT = null;
             RESULT = LexerUtils.makeList(n); flagTok = null; lastIndent = n; 
            return RESULT;
        }
        public List runSemanticAction_146()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > n = (List< Token >) _children[0];
            List RESULT = null;
            
	                            adjustEQARROW(n);
	                            lastIndent = null;
	                            // handles lines that start without any indent
	                            if (inDSL)
	                                inDSL = false;
								if (DSLNext)
									throw new CopperParserException("Indicated DSL with ~ but then did not indent");
	                      		RESULT = n;
	                        
            return RESULT;
        }
        public List runSemanticAction_147()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            List list = (List) _children[0];
            @SuppressWarnings("unchecked") List< Token > n = (List< Token >) _children[1];
            List RESULT = null;
            
	                            	adjustEQARROW(n);
                                if (flagTok != null && flagTok.kind == EQARROW && !isEQARROWlast) {
                                    flagTok = null;
                                }
                                list.addAll(n); RESULT = list;
                            
            return RESULT;
        }
        public List< Token > runSemanticAction_148()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > line = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = line; 
            return RESULT;
        }
        public List< Token > runSemanticAction_149()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[0];
            @SuppressWarnings("unchecked") List< Token > line = (List< Token >) _children[1];
            List< Token > RESULT = null;
             p.addAll(line); RESULT = p; 
            return RESULT;
        }
        public Token runSemanticAction_150()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_151()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_152()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_153()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_154()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_155()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_156()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            java.lang.Object lit = (java.lang.Object) _children[0];
            Token RESULT = null;
             RESULT = token(DSL_LITERAL,(String)lit); 
            return RESULT;
        }
        public List< Token > runSemanticAction_157()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            List list = (List) _children[0];
            Token n = (Token) _children[1];
            List< Token > RESULT = null;
            
						list.add(n);
						RESULT = LexerUtils.<WyvernParserConstants>adjustLogicalLine((LinkedList<Token>)list,
						                    virtualLocation.getFileName(), indents, WyvernParserConstants.class);
					    if (foundTilde) {
						    DSLNext = true;
						    foundTilde = false;
							}
							if (!flagTokSet) {
								flagTok = null;
							}
							flagTokSet = false; // always reset this bool after each line
					
            return RESULT;
        }
        public List< Token > runSemanticAction_158()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_159()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_160()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_161()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_162()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public List< Token > runSemanticAction_163()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public List< Token > runSemanticAction_164()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public List< Token > runSemanticAction_165()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public List< Token > runSemanticAction_166()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > l = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = l; 
            return RESULT;
        }
        public Token runSemanticAction_167()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             foundTilde = true; RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_168()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_169()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_170()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_171()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_172()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_173()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_174()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_175()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_176()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_177()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_178()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_179()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_180()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_181()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_182()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_183()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_184()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_185()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_186()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_187()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_188()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_189()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_190()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_191()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public List< Token > runSemanticAction_192()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > ps = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = ps; 
            return RESULT;
        }
        public List< Token > runSemanticAction_193()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            List< Token > RESULT = null;
             RESULT = LexerUtils.emptyList(); 
            return RESULT;
        }
        public List< Token > runSemanticAction_194()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > e = (List< Token >) _children[0];
            List< Token > RESULT = null;
            
                        adjustEQARROW(e);
                        RESULT = e;
                    
            return RESULT;
        }
        public List< Token > runSemanticAction_195()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public List< Token > runSemanticAction_196()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            @SuppressWarnings("unchecked") List< Token > l = (List< Token >) _children[1];
            List< Token > RESULT = null;
            
                        RESULT = LexerUtils.makeList(t);
                        RESULT.addAll(l);
                        lambdas.pop();
                        // pop the old stack back on
                        indents = metaStack.pop();
                        RESULT.add(LexerUtils.makeToken(WyvernParserConstants.DEDENT, "DEDENT_end_of_lambda", t));
                    
            return RESULT;
        }
        public List< Token > runSemanticAction_197()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = p; 
            return RESULT;
        }
        public List< Token > runSemanticAction_198()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > ps = (List< Token >) _children[0];
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[1];
            List< Token > RESULT = null;
             RESULT = ps; ps.addAll(p); 
            return RESULT;
        }
        public List< Token > runSemanticAction_199()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t1 = (Token) _children[0];
            @SuppressWarnings("unchecked") List< Token > list = (List< Token >) _children[1];
            Token t2 = (Token) _children[2];
            List< Token > RESULT = null;
            
	               RESULT = LexerUtils.makeList(t1);
	               RESULT.addAll(list);
	               RESULT.add(t2);
	           
            return RESULT;
        }
        public List< Token > runSemanticAction_200()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t1 = (Token) _children[0];
            @SuppressWarnings("unchecked") List< Token > list = (List< Token >) _children[1];
            Token t2 = (Token) _children[2];
            List< Token > RESULT = null;
            
	               RESULT = LexerUtils.makeList(t1);
	               RESULT.addAll(list);
	               RESULT.add(t2);
	           
            return RESULT;
        }
        public List< Token > runSemanticAction_201()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            List list = (List) _children[0];
            List< Token > RESULT = null;
             RESULT = list; 
            return RESULT;
        }
        public List< Token > runSemanticAction_202()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            List< Token > RESULT = null;
             RESULT = LexerUtils.emptyList(); 
            return RESULT;
        }
        public List< Token > runSemanticAction_203()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[0];
            List< Token > RESULT = null;
            
	             	RESULT = p;
	             	Token t = ((LinkedList<Token>)p).getLast();
	             	RESULT.addAll(LexerUtils.<WyvernParserConstants>possibleDedentList(
	             	    t, virtualLocation.getFileName(), indents, WyvernParserConstants.class));
	           	
            return RESULT;
        }
        public List< Token > runSemanticAction_204()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[0];
            List list = (List) _children[1];
            List< Token > RESULT = null;
            
	          		// handle the case of ending in an incomplete line
	          		RESULT = p;
	          		List<Token> adjustedList = LexerUtils.<WyvernParserConstants>adjustLogicalLine(
	          		    (LinkedList<Token>)list, virtualLocation.getFileName(), indents, WyvernParserConstants.class);
	          		RESULT.addAll(adjustedList);
	             	Token t = ((LinkedList<Token>)adjustedList).getLast();
	          		RESULT.addAll(LexerUtils.<WyvernParserConstants>possibleDedentList(
	          		    t, virtualLocation.getFileName(), indents, WyvernParserConstants.class));
	          	
            return RESULT;
        }
        public Token runSemanticAction_1(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(ABSTRACT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_2(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(AND,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_3(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
        RESULT = token(EQARROW,lexeme);
        if (flagTok == null) {
            flagTok = RESULT;
			flagTokSet = true;
        }
    
            return RESULT;
        }
        public Token runSemanticAction_4(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(AS,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_5(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(ASSERT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_6(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(BAR,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_7(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(BOOLEAN_LITERAL,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_8(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(BOOLEANAND,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_9(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(BOOLEANNOT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_10(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(BOOLEANOR,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_11(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(RBRACE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_12(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(RBRACK,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_14(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
 		RESULT = token(CHARACTER_LITERAL, replaceEscapeSequences(lexeme.substring(2,lexeme.length()-1)));
 	
            return RESULT;
        }
        public Token runSemanticAction_15(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(CLASS,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_16(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(RPAREN,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_17(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(COLON,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_18(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(COMMA,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_19(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(SINGLE_LINE_COMMENT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_20(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(COMPRISES,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_21(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_22(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DASH,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_23(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DATATYPE, lexeme); flagTok = RESULT; flagTokSet = true; 
            return RESULT;
        }
        public Token runSemanticAction_24(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DECIMAL_LITERAL,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_25(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DEF,lexeme); flagTok = RESULT; flagTokSet = true; 
            return RESULT;
        }
        public Token runSemanticAction_26(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DEFLT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_27(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DIVIDE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_28(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DOT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_29(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DSLLINE,lexeme); flagTok = null; 
            return RESULT;
        }
        public Token runSemanticAction_30(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_31(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(EFFECT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_32(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
		RESULT = token(EQUALS,lexeme);
		if (flagTok != null && flagTok.kind == DEF) {// EQUALS cancels a DEF for the purposes of whether we are looking for a DSL on the next line
			flagTok = null;
			flagTokSet = false;
		}
	
            return RESULT;
        }
        public Token runSemanticAction_33(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(EQUALSEQUALS,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_34(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(EXTENDS,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_35(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(FLOATING_POINT_LITERAL, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_36(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
        ilineNext = true;
        RESULT = token(WHITESPACE,lexeme);
        // save a copy of the indent Stack, adjust the stack to the current indent level
        metaStack.push((Stack<String>) indents.clone());
        String thisIndent = "";
        if (lastIndent != null) {
            thisIndent = lastIndent.image;
        }
        LexerUtils.adjustIndent(thisIndent, RESULT, virtualLocation.getFileName(), indents);
    
            return RESULT;
        }
        public Token runSemanticAction_37(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(FORWARD,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_38(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(GE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_39(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(GT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_40(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
 		RESULT = token(IDENTIFIER,lexeme);
 	
            return RESULT;
        }
        public Token runSemanticAction_41(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
        RESULT = token(WHITESPACE,lexeme);
        if (ilineNext) {
            lambdas.push(lexeme);
            ilineNext = false;
        }
    
            return RESULT;
        }
        public Token runSemanticAction_42(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(IMPORT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_43(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_44(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_45(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(INSTANTIATE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_46(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(LE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_47(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(LIFTED,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_48(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(LT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_49(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(MATCH,lexeme); flagTok = RESULT; flagTokSet = true; 
            return RESULT;
        }
        public Token runSemanticAction_50(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(METADATA,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_51(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(MODULE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_52(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(MULT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_53(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(MULTI_LINE_COMMENT,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_54(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(NEW,lexeme); flagTok = RESULT; flagTokSet = true; 
            return RESULT;
        }
        public Token runSemanticAction_55(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_56(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(NONE,lexeme); 
            return RESULT;
        }
        public java.lang.Object runSemanticAction_57(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            java.lang.Object RESULT = null;
             RESULT = lexeme; 
            return RESULT;
        }
        public Token runSemanticAction_58(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(NOTEQUALS,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_59(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(LBRACE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_60(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(LBRACK,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_63(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(LPAREN,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_64(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(PLUS,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_65(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(POUND,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_66(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(QUESTION,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_67(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(RATIONAL_LITERAL,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_68(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(RECUR,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_69(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(MOD,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_70(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(REQUIRE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_71(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(RESOURCE,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_72(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
 		RESULT = token(STRING_LITERAL, replaceEscapeSequences(lexeme.substring(1,lexeme.length()-1)));
 	
            return RESULT;
        }
        public Token runSemanticAction_73(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(TAGGED,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_74(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(TARROW,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_75(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(TILDE,lexeme); flagTok = RESULT; flagTokSet = true; 
            return RESULT;
        }
        public Token runSemanticAction_76(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(TO,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_77(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(TYPE,lexeme); flagTok = RESULT; flagTokSet = true; 
            return RESULT;
        }
        public Token runSemanticAction_78(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(VAL,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_79(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(VAR,lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_80(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE,lexeme); 
            return RESULT;
        }
        public int runDisambiguationAction(edu.umn.cs.melt.copper.runtime.io.InputPosition _pos,edu.umn.cs.melt.copper.runtime.engines.single.scanner.SingleDFAMatchData match)
        throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            String lexeme = match.lexeme;
            if(match.terms.equals(disambiguationGroups[0])) return disambiguate_0(lexeme);
            else if(match.terms.equals(disambiguationGroups[1])) return disambiguate_1(lexeme);
            else if(match.terms.equals(disambiguationGroups[2])) return disambiguate_2(lexeme);
            else if(match.terms.equals(disambiguationGroups[3])) return disambiguate_3(lexeme);
            else return -1;
        }
        public int disambiguate_0(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unused") final int dsl_indent_t = 30;
            @SuppressWarnings("unused") final int indent_t = 43;
            
		String currentIndent = indents.peek();
		if (lastIndent != null && !(currentIndent.equals(lastIndent.image)))
		    currentIndent = lastIndent.image;
		if (lexeme.length() > currentIndent.length() && lexeme.startsWith(currentIndent)) {
			// indented
			/*if (DSLNext != isDSLNext()) {
			    //throw new RuntimeException("unexpected difference");
			}*/
			if (/*DSLNext*/ isDSLNext() || inDSL) {
				DSLNext = false;
				inDSL = true;
				return dsl_indent_t;
			} else {
				return indent_t;
			}
		}
		if (DSLNext)
			throw new CopperParserException("Indicated DSL with ~ but then did not indent");
		inDSL = false;
		return indent_t;
	
        }
        public int disambiguate_1(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unused") final int fn_newline_t = 36;
            @SuppressWarnings("unused") final int newline_t = 55;
            
        if (isEQARROWlast) {
            return fn_newline_t;
        } else {
            return newline_t;
        }
	
        }
        public int disambiguate_2(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unused") final int fn_newline_t = 36;
            @SuppressWarnings("unused") final int inewline_t = 44;
            @SuppressWarnings("unused") final int newline_t = 55;
            
        if (isEQARROWlast) {
            return fn_newline_t;
        } else if (lambdas.size()>0) {
            return inewline_t;
        } else {
            return newline_t;
        }
	
        }
        public int disambiguate_3(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unused") final int iindent_t = 41;
            @SuppressWarnings("unused") final int whitespace_t = 80;
            
        if (ilineNext) {
            return iindent_t;
        } else {
            if (lambdas.size() == 0) {
                return whitespace_t;
            }
            String lambdaIndent = lambdas.get(lambdas.size()-1);
            if (lexeme.length() >= lambdaIndent.length() && lexeme.startsWith(lambdaIndent)) {
                return iindent_t;
            } else {
                return whitespace_t;
            }
        }
    
        }
    }
    public Semantics semantics;
    public java.lang.Object runSemanticAction(edu.umn.cs.melt.copper.runtime.io.InputPosition _pos,java.lang.Object[] _children,int _prod)
    throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
    {
        return semantics.runSemanticAction(_pos,_children,_prod);
    }
    public java.lang.Object runSemanticAction(edu.umn.cs.melt.copper.runtime.io.InputPosition _pos,edu.umn.cs.melt.copper.runtime.engines.single.scanner.SingleDFAMatchData _terminal)
    throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
    {
        return semantics.runSemanticAction(_pos,_terminal);
    }
    public int runDisambiguationAction(edu.umn.cs.melt.copper.runtime.io.InputPosition _pos,edu.umn.cs.melt.copper.runtime.engines.single.scanner.SingleDFAMatchData matches)
    throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
    {
        return semantics.runDisambiguationAction(_pos,matches);
    }
    public edu.umn.cs.melt.copper.runtime.engines.semantics.SpecialParserAttributes getSpecialAttributes()
    {
        return semantics.getSpecialAttributes();
    }
    public void startEngine(edu.umn.cs.melt.copper.runtime.io.InputPosition initialPos)
    throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
    {
         super.startEngine(initialPos);
         semantics = new Semantics();
    }

public static final byte[] symbolNamesHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\155\224\315\216\333\066" +
"\020\307\205\046\266\345\257\146\201\364\232\127\010\126\337\066" +
"\172\112\203\064\050\262\100\027\165\320\036\172\060\270\022\055" +
"\063\241\110\205\242\326\131\344\225\332\107\351\245\057\021\344" +
"\320\167\050\311\077\145\053\150\057\234\041\147\346\067\303\341" +
"\110\177\374\023\114\172\025\074\375\375\346\035\271\047\317\071" +
"\021\365\363\235\126\114\324\337\377\371\367\257\237\277\074\373" +
"\364\372\233\040\370\330\006\101\360\227\016\036\275\372\371\107" +
"\035\254\311\135\247\025\051\365\233\123\265\327\072\230\020\341" +
"\344\214\050\045\117\320\072\157\133\222\256\243\352\354\171\107" +
"\224\225\253\073\051\071\045\342\206\351\361\326\163\206\255\220" +
"\316\272\364\133\351\102\303\362\145\257\370\203\125\257\312\335" +
"\207\236\050\372\203\251\345\075\165\276\363\222\164\164\110\135" +
"\036\211\255\222\272\270\105\311\115\051\336\264\052\271\354\350" +
"\255\211\025\256\334\122\162\071\150\115\103\100\062\032\025\216" +
"\372\255\321\133\305\072\072\304\077\051\245\320\114\364\164\317" +
"\231\240\366\144\132\221\356\150\225\165\105\064\321\017\355\120" +
"\305\125\105\113\326\020\376\223\320\264\106\051\141\105\017\103" +
"\041\106\045\075\037\372\023\126\354\236\125\016\070\251\160\373" +
"\171\325\361\033\237\144\145\364\075\023\225\057\153\111\017\007" +
"\172\176\205\220\232\146\360\316\325\013\365\162\260\242\037\065" +
"\025\325\271\374\003\227\304\324\137\337\112\006\324\352\040\366" +
"\202\236\206\333\254\016\122\235\210\252\274\377\343\232\102\300" +
"\227\331\002\330\201\341\066\163\066\252\210\065\255\074\277\166" +
"\170\061\054\330\210\176\305\104\247\211\101\020\075\164\351\061" +
"\167\226\045\147\007\115\317\151\071\142\033\242\313\243\077\133" +
"\067\124\023\333\342\341\221\033\131\365\174\300\114\233\036\061" +
"\117\254\302\366\243\067\014\115\001\336\153\076\252\145\056\244" +
"\030\242\027\146\340\316\303\265\064\233\113\003\103\171\231\072" +
"\371\237\251\133\311\273\167\243\047\237\311\341\171\227\262\245" +
"\342\074\146\323\226\367\216\066\153\145\217\121\137\174\350\151" +
"\247\031\206\157\255\210\125\011\367\237\305\102\321\262\127\003" +
"\112\321\206\330\206\342\003\122\246\066\246\206\214\153\105\073" +
"\331\253\362\274\357\216\346\031\360\035\273\140\115\352\372\334" +
"\327\120\137\076\124\315\070\346\155\246\345\320\236\321\125\302" +
"\173\302\057\352\120\313\352\164\144\232\166\055\051\061\252\273" +
"\267\057\176\171\153\377\003\166\120\315\370\021\361\140\265\127" +
"\234\332\356\033\266\237\141\035\174\307\370\305\260\063\167\240" +
"\242\064\307\123\167\334\331\331\342\262\146\045\361\356\163\046" +
"\254\201\063\114\223\240\312\220\314\140\274\247\017\047\035\074" +
"\375\137\326\304\243\146\046\212\052\302\355\124\215\231\127\346" +
"\305\177\333\175\125\137\150\236\311\364\336\264\314\274\156\253" +
"\335\203\275\064\137\270\061\332\232\332\321\336\364\266\375\332" +
"\074\165\173\233\260\125\262\126\244\061\107\256\041\267\246\320" +
"\175\273\331\100\154\235\310\261\313\261\053\260\333\306\020\011" +
"\104\016\121\100\244\020\031\002\020\267\271\206\210\040\020\036" +
"\341\060\302\141\344\017\301\214\100\211\100\211\220\041\102\206" +
"\010\105\104\100\307\240\304\240\304\240\304\240\304\240\304\240" +
"\304\240\304\240\304\240\304\240\044\240\044\240\044\240\044\240" +
"\044\240\044\206\362\310\134\014\127\200\151\003\323\006\011\266" +
"\200\154\075\004\351\022\244\113\220\056\101\170\012\317\024\236" +
"\051\322\155\020\260\101\100\001\227\002\056\005\134\012\244\055" +
"\220\266\360\075\106\134\201\270\024\056\051\134\122\270\244\160" +
"\111\275\013\152\111\121\113\206\104\031\022\145\110\224\201\222" +
"\201\222\201\222\201\222\201\222\201\222\371\071\001\045\007\045" +
"\007\045\007\045\007\045\007\045\007\045\057\134\073\321\324\334" +
"\255\327\156\215\334\032\273\065\161\153\352\126\370\233\244\023" +
"\073\072\327\136\042\337\326\317\345\366\137\345\060\334\231\036" +
"\010\000\000"
});

public static final byte[] symbolDisplayNamesHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\155\224\315\216\333\066" +
"\020\307\225\164\155\313\137\315\002\351\265\267\236\203\325\267" +
"\215\334\032\024\101\320\075\004\130\240\075\024\210\301\225\150" +
"\231\011\105\052\024\265\316\242\257\324\074\112\057\175\211\240" +
"\207\276\103\111\376\051\131\101\173\341\014\071\063\277\031\016" +
"\107\372\343\237\140\326\253\340\371\157\267\357\311\003\171\301" +
"\211\250\137\334\151\305\104\375\362\363\137\277\174\371\373\373" +
"\337\137\077\015\202\117\155\020\004\177\352\340\311\017\072\330" +
"\222\373\116\053\122\352\237\317\325\101\353\140\106\204\223\013" +
"\242\224\074\103\353\274\155\115\272\216\252\321\363\236\050\053" +
"\067\367\122\162\112\304\055\323\323\255\347\014\133\041\235\165" +
"\355\267\322\205\206\345\253\136\361\107\253\136\227\167\037\173" +
"\242\350\217\246\226\017\324\371\056\113\322\321\041\165\171\042" +
"\266\112\352\342\126\045\067\245\170\323\246\344\262\243\157\115" +
"\254\160\345\226\222\313\101\153\032\002\222\321\250\160\324\157" +
"\215\336\052\326\321\041\376\131\051\205\146\242\247\007\316\004" +
"\265\047\363\212\164\047\253\154\053\242\211\176\154\207\052\256" +
"\053\132\262\206\360\067\102\323\032\245\204\025\075\016\205\030" +
"\225\364\174\350\117\130\261\007\126\071\340\254\302\355\227\125" +
"\307\157\175\222\215\321\017\114\124\276\254\065\075\036\351\370" +
"\012\041\065\315\340\235\253\027\352\345\140\103\077\151\052\252" +
"\261\374\043\227\304\324\137\277\225\014\250\315\121\034\004\075" +
"\017\267\331\034\245\072\023\125\171\377\253\232\102\300\227\331" +
"\002\330\221\341\066\113\066\251\210\065\255\034\137\073\274\030" +
"\126\154\102\277\146\242\323\304\040\210\036\272\164\305\235\145" +
"\315\331\121\323\061\055\107\154\103\164\171\362\147\333\206\152" +
"\142\133\074\074\162\043\253\236\017\230\171\323\043\346\231\125" +
"\330\141\362\206\241\051\300\173\055\047\265\054\205\024\103\364" +
"\312\014\334\070\134\153\263\271\064\060\224\227\251\223\377\231" +
"\272\215\274\177\077\171\362\205\034\236\167\055\133\052\306\061" +
"\233\267\274\167\264\105\053\173\214\372\352\143\117\073\315\060" +
"\174\133\105\254\112\270\377\054\126\212\226\275\032\120\212\066" +
"\304\066\024\037\220\062\265\061\065\144\334\052\332\311\136\225" +
"\343\276\073\231\147\300\127\354\202\065\251\353\261\257\241\276" +
"\174\250\232\161\314\333\102\313\241\075\223\253\204\017\204\137" +
"\324\241\226\315\371\304\064\355\132\122\272\320\047\357\354\077" +
"\300\016\251\031\075\042\036\255\366\023\247\266\363\206\353\347" +
"\127\007\337\061\176\061\334\231\372\251\050\315\361\334\035\167" +
"\166\256\270\254\131\111\274\373\222\011\153\340\014\223\044\250" +
"\062\044\063\024\037\350\343\131\007\317\377\227\065\363\250\205" +
"\211\242\212\160\073\121\123\346\265\171\355\137\357\276\252\057" +
"\064\117\144\372\156\332\145\136\266\325\356\261\136\231\257\333" +
"\030\155\115\355\144\157\372\332\176\155\236\273\275\115\330\052" +
"\131\053\322\350\340\351\073\323\215\253\103\273\333\101\354\235" +
"\310\261\313\261\053\260\333\307\020\011\104\016\121\100\244\020" +
"\031\002\020\267\273\201\210\040\020\036\341\060\302\141\344\017" +
"\301\214\100\211\100\211\220\041\102\206\010\105\104\100\307\240" +
"\304\240\304\240\304\240\304\240\304\240\304\240\304\240\304\240" +
"\304\240\044\240\044\240\044\240\044\240\044\240\044\206\362\215" +
"\271\030\256\000\323\016\246\035\022\354\001\331\173\010\322\045" +
"\110\227\040\135\202\360\024\236\051\074\123\244\333\041\140\207" +
"\200\002\056\005\134\012\270\024\110\133\040\155\341\173\214\270" +
"\002\161\051\134\122\270\244\160\111\341\222\172\027\324\222\242" +
"\226\014\211\062\044\312\220\050\003\045\003\045\003\045\003\045" +
"\003\045\003\045\363\163\002\112\016\112\016\112\016\112\016\112" +
"\016\112\016\112\136\270\166\242\251\271\133\157\334\032\271\065" +
"\166\153\342\326\324\255\360\067\111\147\166\164\156\274\104\276" +
"\275\237\313\375\277\320\227\374\260\024\010\000\000"
});

public static final byte[] symbolNumbersHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\201\051\332\323\167\127\202\132\331\253\115\113\231\030\030" +
"\052\012\030\030\030\316\062\214\002\212\201\002\015\260\003\003" +
"\003\023\020\063\242\141\046\054\064\214\315\014\245\131\035\040" +
"\372\321\365\322\003\243\273\217\220\272\301\202\221\303\013\331" +
"\017\314\110\341\012\123\303\004\000\376\105\316\157\117\003\000" +
"\000"
});

public static final byte[] productionLHSsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\201\051\332\323\167\127\202\132\331\253\115\113\231\030\030" +
"\052\012\030\030\030\322\025\030\030\002\201\070\010\212\203\241" +
"\070\004\210\103\241\070\014\212\303\241\070\002\210\043\221\160" +
"\024\035\161\064\022\216\201\342\130\074\070\016\212\343\011\340" +
"\004\072\340\104\050\116\102\302\311\120\234\002\305\251\310\030" +
"\000\050\124\026\320\267\001\000\000"
});

public static final byte[] parseTableHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\355\235\347\227\144\145" +
"\021\306\357\131\100\305\234\021\343\065\200\071\147\105\035\263" +
"\243\254\230\323\032\126\201\005\044\055\253\213\230\020\263\230" +
"\060\347\254\030\061\141\306\204\071\376\031\176\362\034\077\373" +
"\325\152\117\325\313\133\325\163\347\076\125\135\123\003\332\165" +
"\316\357\124\163\273\237\367\251\347\326\231\245\317\316\114\357" +
"\145\377\032\216\072\174\150\070\142\337\276\315\143\376\375\217" +
"\223\216\275\344\342\023\366\014\303\005\007\207\141\070\104\327" +
"\367\354\333\334\173\305\376\343\317\377\347\345\227\312\345\003" +
"\303\272\256\226\165\370\274\341\302\201\266\064\034\330\030\206" +
"\277\216\303\260\207\070\202\070\222\070\212\270\026\161\155\342" +
"\072\304\321\304\165\211\353\365\047\320\177\137\237\270\001\077" +
"\276\041\161\043\342\306\304\115\210\233\022\067\043\156\116\334" +
"\202\270\045\161\014\161\053\342\330\356\214\133\023\267\041\156" +
"\113\334\216\270\075\137\277\003\061\022\167\044\356\304\327\356" +
"\114\334\205\037\037\107\034\117\334\225\270\033\161\167\342\036" +
"\304\075\211\173\021\367\046\356\103\334\227\270\037\153\356\117" +
"\074\200\170\140\347\377\040\342\301\304\103\210\207\022\017\043" +
"\036\116\074\202\170\044\161\002\361\050\342\321\304\143\210\015" +
"\342\261\304\343\210\307\023\117\330\346\046\213\307\023\271\077" +
"\211\170\062\361\024\142\223\170\052\361\064\342\104\363\372\275" +
"\304\323\325\206\336\212\262\070\241\357\121\144\232\052\137\253" +
"\363\372\243\171\062\113\155\350\047\050\234\252\365\050\062\105" +
"\225\257\325\171\375\321\074\231\245\066\364\075\024\116\325\172" +
"\024\231\242\312\327\352\274\376\150\236\314\122\033\172\057\012" +
"\247\152\075\212\114\121\345\153\165\136\177\064\117\146\251\015" +
"\275\036\205\123\265\036\105\246\250\362\265\072\257\077\232\047" +
"\263\324\206\176\214\302\251\132\217\042\123\124\371\132\235\327" +
"\037\315\223\131\152\103\237\100\341\124\255\107\221\051\252\174" +
"\255\316\353\217\346\311\054\265\241\137\242\160\252\326\243\310" +
"\024\125\276\126\347\365\107\363\144\226\332\320\257\121\070\125" +
"\353\121\144\212\052\137\253\363\372\243\171\062\113\155\350\127" +
"\050\234\252\365\050\062\105\225\257\325\171\375\321\074\231\245" +
"\066\364\051\024\116\325\172\024\231\242\312\327\352\274\376\150" +
"\236\314\122\033\372\000\012\247\152\075\212\114\121\345\153\165" +
"\136\177\064\117\146\251\015\375\000\205\123\265\036\105\246\250" +
"\362\265\072\257\077\232\047\263\324\206\276\213\302\251\132\217" +
"\042\123\124\371\132\235\327\037\315\223\131\152\103\137\100\341" +
"\124\255\107\221\051\252\174\255\316\353\217\346\311\054\265\241" +
"\267\241\160\252\326\243\310\024\125\276\126\347\365\107\363\144" +
"\226\332\320\227\120\070\125\353\121\144\212\052\137\253\363\372" +
"\243\171\062\113\155\350\033\050\013\145\337\243\310\024\125\276" +
"\126\347\365\107\363\144\226\332\320\153\120\070\125\353\121\144" +
"\212\052\137\253\363\372\243\171\062\113\155\350\143\050\234\252" +
"\365\050\062\105\225\257\325\171\375\321\074\231\245\066\364\132" +
"\024\116\325\172\024\231\242\312\327\352\274\376\150\236\314\122" +
"\033\172\047\012\247\152\075\212\114\121\345\153\165\136\177\064" +
"\117\146\251\015\175\013\205\123\265\036\105\246\250\362\265\072" +
"\257\077\232\047\263\324\206\056\107\341\124\255\107\221\051\252" +
"\174\255\316\353\217\346\311\054\265\241\367\243\160\252\326\243" +
"\310\024\125\276\126\347\365\107\363\144\226\332\320\267\121\070" +
"\125\353\121\144\212\052\137\253\363\372\243\171\062\113\155\350" +
"\073\050\234\252\365\050\062\105\225\257\325\171\375\321\074\231" +
"\245\066\364\166\024\116\325\172\024\231\242\312\327\352\274\376" +
"\150\236\314\122\033\372\070\012\247\152\075\212\114\121\345\153" +
"\165\136\177\064\117\146\251\015\275\001\205\123\265\036\105\246" +
"\250\362\265\072\257\077\232\047\263\324\206\256\100\341\124\255" +
"\107\221\051\252\174\255\316\353\217\346\311\054\265\241\237\242" +
"\160\252\326\243\310\024\125\276\126\347\365\107\363\144\226\332" +
"\320\347\121\070\125\353\121\144\212\052\137\253\363\372\243\171" +
"\062\113\155\350\142\024\116\325\172\024\231\242\312\327\352\274" +
"\376\150\236\314\122\033\372\040\112\177\102\177\315\163\106\177" +
"\316\324\163\123\327\266\323\315\371\241\376\021\046\157\363\012" +
"\245\066\364\036\024\116\325\172\024\231\242\312\327\352\274\376" +
"\150\236\314\122\033\372\071\012\247\152\075\212\114\121\345\153" +
"\165\136\177\064\117\146\251\015\275\033\205\123\265\036\105\246" +
"\250\362\265\072\257\077\232\047\263\324\206\176\206\302\251\132" +
"\217\042\123\124\371\132\235\327\037\315\223\131\152\103\357\100" +
"\341\124\255\107\221\051\252\174\255\316\353\217\346\311\054\265" +
"\241\213\120\070\125\353\121\144\212\052\137\253\363\372\243\171" +
"\062\113\155\350\055\050\234\252\365\050\062\105\225\257\325\171" +
"\375\321\074\231\245\066\364\115\224\205\262\357\121\144\212\052" +
"\137\253\363\372\243\171\062\113\155\350\213\050\234\252\365\050" +
"\062\105\225\257\325\171\375\321\074\231\245\066\364\146\024\116" +
"\325\172\024\231\242\312\327\352\274\376\150\236\314\122\033\372" +
"\034\112\177\102\177\315\163\306\234\146\253\347\262\375\154\206" +
"\125\230\273\323\321\122\033\172\043\012\247\152\075\212\114\121" +
"\345\153\165\136\177\064\117\146\251\015\375\002\205\123\265\036" +
"\105\246\250\362\265\072\257\077\232\047\263\256\332\220\107\105" +
"\323\034\336\211\151\166\272\306\141\070\151\227\375\237\341\325" +
"\350\015\215\216\317\150\334\030\206\337\260\146\107\076\243\221" +
"\170\346\070\361\031\215\235\356\270\021\373\214\306\147\215\073" +
"\374\031\215\304\263\273\363\236\143\357\364\330\175\106\143\167" +
"\155\223\373\163\211\023\211\347\021\317\047\136\100\354\135\074" +
"\027\337\120\347\362\337\015\155\320\306\306\365\206\344\274\350" +
"\206\136\070\116\156\210\356\360\327\121\026\312\276\107\221\111" +
"\253\174\255\316\353\217\346\311\054\265\241\037\242\160\252\326" +
"\243\310\024\125\276\126\347\365\107\363\144\226\332\320\217\120" +
"\070\125\353\121\144\212\052\137\253\363\372\243\171\062\113\155" +
"\350\323\050\234\252\365\050\062\105\225\257\325\171\375\321\074" +
"\231\245\066\164\011\012\247\152\075\212\114\121\345\153\165\136" +
"\177\064\117\146\251\015\135\206\302\251\132\217\042\123\124\371" +
"\132\235\327\037\315\223\131\152\103\157\102\341\124\255\107\221" +
"\051\252\174\255\316\353\217\346\311\054\265\241\367\241\160\252" +
"\326\243\310\024\125\276\126\347\365\107\363\144\226\332\320\047" +
"\121\070\125\353\121\144\212\052\137\253\363\372\243\171\062\113" +
"\155\350\135\050\234\252\365\050\062\105\225\257\325\171\375\321" +
"\074\231\245\066\364\175\024\116\325\172\024\231\242\312\327\352" +
"\274\376\150\236\314\122\033\372\032\012\247\152\075\212\114\121" +
"\345\153\165\136\177\064\117\146\251\015\135\210\302\251\132\217" +
"\042\123\124\371\132\235\327\037\315\223\131\152\103\347\243\160" +
"\252\326\243\310\024\125\276\126\347\365\107\363\144\226\332\320" +
"\005\050\234\252\365\050\062\105\225\257\325\171\375\321\074\231" +
"\245\066\364\072\024\116\325\172\024\231\242\312\327\352\274\376" +
"\150\236\314\122\033\372\014\012\247\152\075\212\114\121\345\153" +
"\165\136\177\064\117\146\251\015\135\212\302\251\132\217\042\123" +
"\124\371\132\235\327\037\315\223\131\152\103\177\031\257\041\377" +
"\226\144\247\103\277\013\376\242\261\366\273\340\373\354\235\036" +
"\201\357\202\233\327\057\177\027\374\157\343\056\154\210\372\213" +
"\307\377\241\177\355\223\036\277\204\373\113\315\175\152\033\042" +
"\136\306\217\067\211\375\343\304\277\366\271\350\152\103\137\101" +
"\131\050\373\036\105\246\251\362\265\072\257\077\232\047\263\324" +
"\206\076\202\322\237\320\137\363\234\061\247\331\352\271\154\077" +
"\233\141\025\346\356\164\264\324\206\076\204\322\237\320\137\363" +
"\234\321\237\063\365\334\324\265\355\164\163\176\250\177\204\311" +
"\333\274\102\251\015\175\031\205\123\265\036\105\246\250\362\265" +
"\072\257\077\232\047\263\324\206\276\212\302\251\132\217\042\123" +
"\124\371\132\235\327\037\315\223\131\127\155\150\377\116\034\277" +
"\256\225\053\374\223\365\257\332\231\171\152\152\034\206\227\357" +
"\366\014\150\305\066\064\016\303\053\166\146\236\165\331\212\155" +
"\150\267\152\034\206\223\273\307\247\354\336\044\130\215\303\160" +
"\052\161\200\070\055\172\206\336\320\306\060\374\016\101\136\353" +
"\321\114\235\023\365\215\170\133\115\364\234\271\074\231\245\336" +
"\313\235\201\302\251\132\217\042\123\124\371\132\235\327\037\315" +
"\223\131\113\137\103\277\105\220\327\172\064\123\347\104\175\043" +
"\336\126\023\075\147\056\117\146\251\257\241\127\242\054\224\175" +
"\217\042\123\124\371\132\235\327\037\315\223\131\361\167\012\343" +
"\060\234\236\077\317\272\154\055\375\051\367\007\004\171\255\107" +
"\063\165\116\324\067\342\155\065\321\163\346\362\144\326\112\277" +
"\151\174\045\153\344\367\130\257\034\327\277\307\052\347\205\176" +
"\217\225\037\237\301\175\213\337\064\136\245\306\035\372\163\370" +
"\377\275\324\073\205\317\242\364\047\364\327\074\147\314\151\266" +
"\172\056\333\317\146\130\205\271\073\035\055\265\241\017\243\364" +
"\047\364\327\074\147\364\347\114\075\067\165\155\073\335\234\037" +
"\352\037\141\362\066\257\120\273\373\267\076\343\060\234\271\033" +
"\276\327\244\122\137\103\037\105\351\117\350\257\171\316\230\323" +
"\154\365\134\266\237\315\260\012\163\167\072\132\152\103\247\241" +
"\364\047\364\327\074\147\314\151\266\172\056\333\317\146\130\205" +
"\271\073\035\055\265\241\277\217\353\237\227\273\172\377\274\334" +
"\351\050\375\111\375\065\317\031\163\232\255\236\313\366\263\031" +
"\126\141\330\241\132\177\172\131\261\377\131\136\215\372\032\072" +
"\204\262\120\366\075\212\114\121\345\153\165\136\177\064\117\146" +
"\055\375\275\334\131\010\375\011\375\065\124\157\317\231\172\156" +
"\352\232\327\153\112\267\235\177\204\351\373\034\257\245\015\235" +
"\207\040\257\365\150\246\316\211\234\021\365\265\272\250\377\134" +
"\236\314\312\373\004\100\176\134\366\136\216\372\331\043\370\136" +
"\216\137\137\371\136\356\034\173\247\307\225\337\313\055\376\153" +
"\143\030\176\217\040\257\365\150\246\316\361\234\101\123\237\054" +
"\072\172\174\112\304\157\025\177\064\117\167\227\117\345\176\256" +
"\175\016\255\245\015\235\203\040\257\365\150\246\316\211\234\021" +
"\365\265\272\250\377\134\236\314\122\357\345\376\214\302\251\132" +
"\217\042\123\124\371\132\235\327\037\315\223\131\113\137\103\177" +
"\104\220\327\172\064\123\347\104\175\043\336\126\023\075\147\056" +
"\117\146\251\257\241\077\241\160\252\326\243\310\024\125\276\126" +
"\347\365\107\363\144\226\332\320\231\050\375\011\375\065\317\031" +
"\163\232\255\236\313\366\263\031\126\141\356\116\107\053\374\163" +
"\333\007\167\146\236\165\331\132\372\377\320\101\004\171\255\107" +
"\063\165\116\344\214\250\257\325\105\375\347\362\144\326\322\206" +
"\316\106\350\117\350\257\241\172\173\316\324\163\123\327\274\136" +
"\123\272\355\374\043\114\337\347\170\055\155\350\134\004\171\255" +
"\107\063\165\116\344\214\250\257\325\105\375\347\362\144\326\372" +
"\273\017\305\376\356\277\273\013\157\350\325\136\247\165\305\352" +
"\077\072\216\362\217\115\272\000\000"
});

public static final byte[] shiftableSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\103\121\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\000\322\250\240\242\270\220\241\216\201\251\024\104" +
"\262\202\024\314\375\377\366\375\374\177\307\377\103\244\377\377" +
"\307\242\340\353\377\371\377\257\103\024\060\216\052\030\125\060" +
"\252\140\124\001\165\025\074\105\024\101\203\327\221\303\103\301" +
"\333\367\367\151\133\332\103\252\034\016\006\030\300\026\335\377" +
"\347\377\273\376\017\137\172\000\132\161\034\237\202\301\020\222" +
"\243\012\206\223\002\202\105\020\345\031\207\240\011\064\057\006" +
"\241\131\222\021\147\336\204\144\133\074\231\227\201\260\002\041" +
"\006\144\200\043\167\343\315\376\204\043\213\102\023\040\116\023" +
"\240\310\221\004\024\240\006\064\216\206\067\145\351\001\044\256" +
"\200\077\250\011\132\101\171\232\044\140\002\021\325\001\241\350" +
"\256\377\012\162\003\276\270\370\116\040\262\050\067\201\260\002" +
"\232\047\132\202\101\315\100\070\250\151\036\120\004\243\033\303" +
"\221\000\243\302\161\130\022\017\000\000"
});

public static final byte[] layoutSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\103\121\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\000\322\250\240\242\270\220\241\216\201\251\024\104" +
"\262\216\052\030\125\060\252\140\124\301\250\202\121\005\243\012" +
"\106\025\214\052\030\125\060\252\140\124\301\250\202\121\005\164" +
"\123\000\000\114\074\102\245\022\017\000\000"
});

public static final byte[] prefixSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\103\121\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\000\322\250\240\242\270\220\241\216\201\251\024\104" +
"\262\216\052\030\125\060\252\140\124\301\250\202\121\005\243\012" +
"\106\025\214\052\030\125\060\252\140\124\301\250\202\121\005\164" +
"\123\000\000\114\074\102\245\022\017\000\000"
});

public static final byte[] prefixMapsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\355\314\241\016\001\001" +
"\034\300\341\377\156\074\001\345\336\100\272\240\010\232\211\212" +
"\211\227\056\010\147\154\347\166\147\222\107\360\044\212\047\261" +
"\311\262\306\063\120\064\121\262\357\227\177\373\116\217\350\266" +
"\165\364\363\174\266\052\166\105\326\066\345\072\233\224\315\142" +
"\331\214\323\353\363\074\272\337\206\111\304\276\212\210\372\075" +
"\366\276\174\233\164\320\271\034\247\325\347\233\127\277\256\335" +
"\306\041\022\064\032\215\106\243\321\150\064\032\215\106\243\321" +
"\150\064\032\215\106\243\321\150\064\032\215\106\243\321\150\064" +
"\032\215\106\243\321\177\112\277\000\235\017\065\071\321\050\000" +
"\000"
});

public static final byte[] terminalUsesHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\201\051\332\323\167\127\202\132\331\253\115\113\231\030\030" +
"\052\012\030\030\030\002\031\106\001\305\000\000\266\123\065\060" +
"\137\001\000\000"
});

public static final byte[] shiftableUnionHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\270" +
"\210\101\040\053\261\054\121\257\264\044\063\107\317\051\263\044" +
"\070\265\044\357\157\107\235\245\311\152\105\146\006\306\150\006" +
"\226\244\314\222\342\022\006\246\150\257\212\202\322\042\060\255" +
"\300\262\125\150\143\351\144\046\006\206\212\002\006\006\006\246" +
"\371\377\101\340\376\177\006\020\140\374\377\277\002\000\113\262" +
"\235\215\131\000\000\000"
});

public static final byte[] acceptSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\355\131\275\116\303\060" +
"\020\276\270\056\212\230\242\062\261\031\046\246\116\054\210\045" +
"\252\072\041\066\306\116\105\142\050\002\124\332\004\165\252\042" +
"\046\046\026\036\003\026\006\236\203\047\341\021\220\110\323\164" +
"\161\174\116\316\166\322\124\042\103\253\366\363\375\370\363\371" +
"\073\047\371\370\201\156\074\203\203\321\345\355\370\151\334\217" +
"\243\311\135\177\060\211\256\156\242\363\373\303\023\376\375\072" +
"\234\062\200\305\024\300\033\316\147\020\310\243\036\176\137\226" +
"\147\247\357\107\035\360\106\300\257\047\321\074\002\066\272\130" +
"\114\123\247\253\157\301\277\172\237\361\133\356\043\375\234\077" +
"\302\022\130\274\372\354\246\277\075\006\353\213\002\170\144\040" +
"\275\102\212\205\357\070\070\103\000\137\151\021\270\012\316\066" +
"\044\346\227\247\112\042\101\054\367\127\224\345\166\344\011\143" +
"\200\347\210\324\044\010\004\045\206\314\204\050\130\366\264\205" +
"\310\361\211\206\145\261\030\231\073\136\342\322\127\132\172\250" +
"\313\200\310\072\144\066\325\055\164\131\051\055\144\212\012\023" +
"\306\253\350\131\273\116\050\100\054\141\014\360\264\301\131\001" +
"\120\217\024\304\374\351\232\143\047\024\274\150\071\040\147\007" +
"\310\104\235\211\252\137\173\327\010\021\256\154\244\121\010\107" +
"\135\020\025\323\254\253\154\245\214\314\232\002\226\056\122\211" +
"\215\235\030\122\020\213\341\253\000\106\235\240\041\211\201\075" +
"\355\104\126\205\002\220\044\003\347\152\147\262\102\316\024\222" +
"\113\112\137\154\006\010\325\300\036\225\273\106\322\005\172\360" +
"\120\127\106\252\046\000\030\120\143\341\265\251\175\207\145\003" +
"\222\352\255\111\076\251\025\224\257\164\100\173\073\222\256\361" +
"\130\027\311\026\174\153\232\000\043\122\120\073\377\325\225\101" +
"\276\207\265\040\257\035\113\130\255\107\251\250\370\047\315\200" +
"\264\155\313\214\331\051\117\064\272\307\254\126\114\150\026\035" +
"\131\220\332\312\004\017\332\301\055\152\152\303\273\324\012\101" +
"\165\152\310\037\166\050\000\324\302\251\253\026\356\116\203\077" +
"\112\245\130\167\046\106\153\126\015\354\174\276\233\221\211\351" +
"\246\163\241\233\145\073\105\171\174\046\337\010\011\204\053\214" +
"\135\013\171\167\240\346\262\266\221\036\102\220\001\206\326\221" +
"\341\063\223\352\365\324\162\171\331\166\336\011\122\264\110\331" +
"\230\304\360\035\056\276\103\200\153\013\114\230\012\126\361\235" +
"\101\346\062\161\223\366\061\020\311\224\367\171\110\332\152\202" +
"\112\152\366\146\315\321\076\347\126\023\125\050\004\107\271\133" +
"\057\020\131\205\124\157\002\041\173\075\347\204\001\261\006\376" +
"\000\045\216\043\027\324\037\000\000"
});

public static final byte[] rejectSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\243\113\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\103\315\000\222\305\205\014\165\014\114\245\040\222\165\124" +
"\140\124\140\124\140\110\012\060\202\321\340\161\317\250\300\360" +
"\025\030\115\153\243\301\060\274\203\001\247\237\206\243\147\007" +
"\213\300\150\330\216\012\014\142\201\321\344\071\032\014\243\002" +
"\203\135\200\370\344\111\315\204\074\014\062\305\040\011\216\141" +
"\020\222\103\067\360\251\151\033\025\062\042\135\222\321\300\252" +
"\244\153\260\015\226\050\001\000\213\007\162\132\344\026\000\000" +
""
});

public static final byte[] possibleSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\355\127\077\157\323\100" +
"\024\177\167\271\040\213\001\131\145\142\163\020\124\235\252\252" +
"\142\101\054\126\325\011\261\061\146\241\225\030\202\000\205\306" +
"\101\235\052\303\304\304\302\027\310\016\013\003\173\277\101\371" +
"\042\174\004\010\147\307\264\301\367\176\167\361\305\211\235\252" +
"\036\022\305\277\367\377\336\275\337\313\267\137\324\035\237\320" +
"\335\376\263\127\107\357\217\166\307\311\340\365\356\301\040\171" +
"\376\062\171\362\346\336\216\272\370\174\070\224\104\247\103\042" +
"\161\070\072\241\260\054\365\366\367\247\263\307\217\276\366\072" +
"\044\372\244\216\007\311\050\041\331\177\172\072\324\106\263\357" +
"\110\375\330\372\076\376\122\330\320\237\243\167\164\106\162\234" +
"\175\166\365\157\071\235\075\177\062\220\304\164\132\026\020\132" +
"\225\042\106\123\003\202\242\160\002\000\316\127\156\052\246\342" +
"\121\246\346\061\320\024\001\016\342\003\000\142\140\052\017\102" +
"\162\200\026\337\011\070\040\004\316\073\070\321\031\120\074\077" +
"\371\112\134\011\010\056\312\163\140\372\066\275\270\324\163\372" +
"\076\007\005\210\370\343\011\172\127\101\005\246\346\035\130\123" +
"\221\131\114\115\040\015\103\324\012\126\137\345\012\105\206\351" +
"\055\334\022\032\120\010\040\025\003\137\227\215\051\331\216\336" +
"\116\241\111\241\034\341\007\254\146\047\142\213\254\137\356\361" +
"\171\075\264\044\114\041\274\210\373\006\220\127\224\211\252\024" +
"\266\160\011\220\053\161\323\202\370\010\317\015\364\312\054\077" +
"\113\253\247\063\137\373\154\001\324\204\065\051\142\076\210\133" +
"\171\164\322\004\310\332\156\025\001\174\215\364\104\205\032\051" +
"\002\042\327\071\061\243\366\000\005\161\037\001\260\002\226\322" +
"\170\015\147\166\006\107\165\317\340\314\127\014\064\127\065\142" +
"\255\263\167\076\132\166\036\072\206\263\176\311\327\064\100\305" +
"\226\010\120\366\071\017\133\232\041\200\042\336\012\341\346\225" +
"\140\072\366\337\224\256\002\350\250\122\020\356\066\166\316\114" +
"\255\342\174\330\262\113\224\007\112\260\207\252\333\265\016\214" +
"\075\004\030\204\345\236\343\344\022\250\310\004\315\010\154\102" +
"\026\266\035\150\176\214\140\376\066\156\125\111\323\144\253\222" +
"\200\311\017\271\351\011\023\124\116\231\134\264\032\260\122\146" +
"\145\002\254\205\347\074\330\252\106\122\042\004\100\266\042\004" +
"\100\215\352\300\242\214\030\272\004\134\175\107\334\046\075\057" +
"\140\216\344\222\000\173\322\113\060\244\125\240\275\014\151\043" +
"\102\206\326\010\001\076\014\271\016\037\036\054\134\063\165\232" +
"\177\037\041\165\322\177\155\344\103\072\313\013\264\205\370\310" +
"\046\100\056\001\247\205\205\004\126\134\352\345\005\156\016\153" +
"\321\105\250\135\353\314\352\167\020\270\152\300\065\240\072\320" +
"\350\252\041\213\103\141\235\263\000\324\150\351\072\263\251\053" +
"\305\312\131\335\307\224\145\017\170\300\047\270\051\164\117\113" +
"\013\130\135\254\141\376\337\324\341\132\220\124\243\134\004\247" +
"\276\225\213\240\006\013\040\215\065\320\101\323\103\375\172\216" +
"\117\327\275\252\363\332\370\335\216\105\332\255\326\156\362\153" +
"\232\326\365\106\033\116\266\216\163\152\366\070\370\342\126\057" +
"\221\263\022\326\104\121\076\036\141\043\106\203\246\134\300\137" +
"\126\241\324\206\104\043\000\000"
});

public static final byte[] cMapHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\355\321\067\112\105\121" +
"\024\005\320\367\315\071\347\234\163\316\161\000\026\216\300\306" +
"\041\210\240\070\041\073\053\113\207\044\070\007\267\360\212\217" +
"\210\374\302\112\326\205\305\345\156\316\071\267\070\057\037\105" +
"\343\303\175\121\167\163\165\375\166\273\364\370\376\372\134\127" +
"\024\117\167\105\245\370\072\225\032\364\305\150\325\373\250\306" +
"\276\132\147\137\306\156\314\226\331\104\054\304\166\354\307\161" +
"\164\106\117\114\105\103\254\104\107\214\305\370\057\206\112\355" +
"\345\354\213\130\216\336\330\051\263\245\157\332\176\310\276\353" +
"\212\301\032\352\252\115\306\100\254\127\375\373\165\157\304\126" +
"\144\057\305\134\234\305\110\324\307\164\254\306\136\131\337\022" +
"\303\321\032\215\321\034\153\321\035\363\161\022\007\321\037\207" +
"\161\036\247\145\157\123\314\304\146\054\376\341\016\001\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000" +
"\000\000\000\000\000\000\000\000\000\000\370\147\076\001\361\054" +
"\331\111\033\000\004\000"
});

public static final byte[] deltaHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\355\235\007\270\325\064" +
"\024\307\223\213\200\042\012\202\212\340\000\021\021\034\010\367" +
"\001\216\207\114\027\056\160\017\034\117\334\133\124\334\342\036" +
"\050\356\275\365\241\342\036\210\173\357\075\160\341\336\173\357" +
"\275\162\261\327\257\264\151\232\246\111\232\364\234\367\175\377" +
"\357\265\047\155\222\373\173\347\234\246\367\336\236\167\355\127" +
"\244\345\370\275\110\213\061\143\106\166\372\345\303\121\235\117" +
"\236\070\250\102\310\376\173\022\102\127\146\366\312\230\221\153" +
"\337\331\324\163\337\317\247\136\036\230\311\140\002\364\147\374" +
"\070\062\201\060\012\377\023\250\155\267\140\232\215\251\045\123" +
"\053\246\326\301\376\354\114\163\004\333\155\230\346\144\152\313" +
"\064\027\323\334\114\355\230\332\063\315\303\324\201\251\143\160" +
"\354\274\114\363\061\315\317\324\211\151\201\300\326\231\251\013" +
"\323\202\301\161\013\061\055\314\264\110\260\337\225\251\133\260" +
"\275\050\123\167\246\305\202\375\036\114\213\063\365\014\366\227" +
"\140\352\305\324\073\330\137\062\370\135\323\122\114\113\063\055" +
"\023\354\367\011\176\057\313\324\227\113\040\252\176\011\166\025" +
"\125\065\366\045\073\267\006\121\073\227\100\377\100\265\355\001" +
"\301\050\265\375\201\221\266\012\347\370\260\055\334\126\127\065" +
"\345\170\136\177\111\155\313\205\346\046\032\273\201\360\347\042" +
"\107\240\177\150\224\330\331\005\023\010\317\115\057\201\074\121" +
"\260\174\112\273\177\121\240\323\007\126\040\146\174\140\305\224" +
"\261\263\371\100\077\303\152\264\060\106\124\203\104\355\336\345" +
"\201\225\022\346\246\067\017\270\114\100\107\046\034\234\112\100" +
"\045\333\310\312\217\114\050\073\312\020\246\241\240\011\224\327" +
"\007\164\346\201\141\304\275\074\200\231\160\170\052\001\214\002" +
"\027\011\214\360\212\300\312\006\010\330\365\001\137\362\300\052" +
"\304\124\046\314\353\003\042\255\252\261\057\331\271\255\046\152" +
"\317\105\140\165\311\131\216\014\155\127\203\375\221\222\347\206" +
"\265\206\042\201\174\121\260\046\161\067\012\326\042\152\121\260" +
"\066\111\213\202\360\050\353\070\114\140\224\042\001\161\036\030" +
"\315\121\222\335\005\345\236\233\225\074\020\126\236\253\341\272" +
"\031\346\226\057\017\250\214\142\203\200\352\334\220\000\022\360" +
"\207\300\172\340\011\344\361\201\365\203\337\033\150\041\340\313" +
"\175\301\206\104\155\075\260\021\021\255\007\134\362\201\215\045" +
"\216\301\050\160\217\300\046\206\010\154\352\015\001\236\066\213" +
"\020\330\054\142\163\317\007\104\231\160\014\121\313\204\233\023" +
"\375\231\060\074\067\321\330\156\275\103\342\107\036\160\341\152" +
"\270\205\240\055\072\267\055\123\306\306\117\317\263\175\172\276" +
"\025\107\115\011\366\064\155\315\261\215\125\354\053\111\365\271" +
"\155\043\070\146\133\121\037\230\007\142\004\266\343\150\373\004" +
"\173\232\166\340\330\166\124\354\053\111\321\271\355\304\071\146" +
"\147\121\037\350\003\326\011\354\002\236\200\037\076\020\276\136" +
"\356\112\344\326\003\273\161\154\025\316\171\072\327\204\273\207" +
"\346\046\032\073\274\036\330\043\332\277\325\025\321\236\232\011" +
"\344\131\025\217\023\022\160\061\012\366\312\061\267\162\344\201" +
"\275\255\021\300\125\061\176\152\146\072\012\366\321\330\227\271" +
"\074\340\302\335\161\261\357\220\230\040\060\036\074\001\023\076" +
"\260\157\251\011\354\047\101\300\234\017\250\144\033\131\371\167" +
"\137\340\162\024\140\036\110\042\260\177\056\002\340\176\254\257" +
"\212\017\260\060\106\276\125\261\311\050\070\220\140\036\260\117" +
"\340\240\314\004\016\346\350\220\004\273\212\252\032\373\222\235" +
"\133\203\250\075\106\140\002\107\207\046\330\153\072\114\320\306" +
"\323\341\031\217\117\223\150\156\165\035\041\152\327\022\005\107" +
"\162\154\256\104\201\132\036\070\052\043\001\023\171\340\150\101" +
"\333\061\306\011\104\005\157\125\234\227\100\171\237\262\071\226" +
"\044\173\360\161\034\033\317\363\334\317\003\370\076\241\216\050" +
"\020\151\242\306\276\314\105\201\156\002\307\207\266\153\121\160" +
"\102\304\346\057\201\362\076\151\245\333\007\046\105\010\114\212" +
"\330\334\363\201\242\357\214\116\044\105\136\013\134\040\140\352" +
"\152\170\022\170\002\047\033\045\160\212\007\004\362\107\301\251" +
"\202\331\373\340\003\162\004\160\115\130\341\050\357\325\360\264" +
"\320\166\065\330\077\055\147\237\131\346\126\374\172\040\054\367" +
"\357\015\117\347\350\214\004\173\232\316\344\330\252\212\175\045" +
"\111\146\156\147\211\332\143\004\316\346\350\234\004\173\232\316" +
"\345\330\252\212\175\045\111\146\156\347\211\332\101\255\007\316" +
"\347\275\006\253\004\056\050\230\200\374\172\000\166\046\104\002" +
"\110\300\004\201\013\043\004\056\214\330\334\043\340\302\265\340" +
"\042\101\133\061\167\106\027\133\046\120\354\265\300\005\037\270" +
"\004\074\201\113\013\043\200\317\033\066\151\124\063\307\066\131" +
"\363\030\165\135\046\150\273\134\164\156\214\300\025\034\115\111" +
"\260\313\350\312\310\176\065\107\137\252\163\273\112\324\036\043" +
"\160\065\107\327\044\330\323\164\255\342\171\131\124\237\333\165" +
"\252\175\340\232\320\172\046\274\136\261\057\173\231\020\237\073" +
"\336\136\243\156\340\330\156\324\074\106\124\067\161\154\123\105" +
"\347\304\010\334\314\321\264\004\273\214\156\211\354\127\163\364" +
"\245\072\267\133\105\355\061\002\267\161\164\173\202\075\115\167" +
"\050\236\227\105\321\271\335\231\265\017\274\026\130\317\204\167" +
"\051\366\145\057\023\342\247\146\265\155\027\356\015\361\375\001" +
"\035\004\356\316\105\340\236\022\020\320\353\003\367\202\047\240" +
"\303\007\356\003\117\240\150\037\270\137\232\100\124\260\126\104" +
"\110\000\127\104\111\261\366\000\361\077\017\370\225\011\037\004" +
"\117\300\244\017\074\004\226\300\303\274\327\200\317\236\203\362" +
"\201\107\170\257\001\024\001\271\114\210\117\136\037\142\130\215" +
"\026\306\210\152\220\250\035\237\075\217\021\070\064\243\036\315" +
"\170\374\143\012\143\344\325\343\242\366\030\201\047\070\172\062" +
"\301\376\124\202\135\244\247\025\316\021\051\151\156\141\075\043" +
"\152\217\021\170\226\243\347\022\354\065\075\057\150\263\041\321" +
"\334\244\144\075\017\114\317\170\274\375\074\040\263\036\170\201" +
"\224\171\075\120\246\025\321\213\132\010\274\344\061\001\364\201" +
"\227\301\023\100\037\120\043\200\357\224\126\070\312\373\156\371" +
"\053\241\355\152\260\377\112\316\076\263\314\015\077\057\050\236" +
"\300\214\010\201\031\021\233\173\004\312\222\011\137\045\252\327" +
"\202\327\112\102\240\374\127\303\327\301\023\220\361\201\067\274" +
"\045\360\246\046\002\152\076\020\025\126\140\360\141\075\360\226" +
"\066\002\334\232\276\032\145\352\277\170\274\055\150\313\126\257" +
"\130\265\316\203\254\114\325\240\170\107\160\114\266\032\024\246" +
"\243\140\037\215\175\231\211\002\137\363\100\135\357\346\046\340" +
"\153\036\250\353\075\216\055\133\036\320\131\211\205\047\323\225" +
"\130\336\347\034\223\275\022\213\217\171\100\137\024\324\266\135" +
"\130\023\312\254\212\077\010\315\115\064\266\237\253\142\031\002" +
"\037\032\043\240\073\012\260\012\107\221\367\206\141\037\370\210" +
"\367\032\122\011\174\134\042\002\345\313\003\252\004\076\001\113" +
"\340\123\336\153\210\021\230\242\131\237\105\366\033\015\214\221" +
"\246\317\105\355\061\002\327\150\324\027\232\373\023\351\113\325" +
"\163\113\167\137\300\123\266\373\202\046\215\152\346\330\276\322" +
"\074\106\135\372\052\261\230\256\101\061\126\261\057\173\065\050" +
"\124\377\006\074\361\174\300\375\152\074\066\174\340\353\100\156" +
"\372\200\151\002\356\127\142\301\172\104\270\036\370\206\243\157" +
"\023\354\052\032\255\261\057\055\163\303\357\021\141\036\210\021" +
"\230\246\131\337\105\366\033\015\214\221\246\357\105\355\061\002" +
"\267\153\324\017\232\373\223\321\217\131\317\301\073\043\353\165" +
"\311\176\322\074\206\376\272\144\130\233\016\153\323\331\360\201" +
"\237\003\271\351\003\246\011\270\137\227\014\253\363\341\172\340" +
"\027\216\176\115\260\253\150\264\306\276\264\314\015\357\214\060" +
"\017\200\372\324\254\276\377\033\021\175\152\126\077\362\367\022" +
"\023\020\177\156\010\301\007\376\000\117\340\117\360\004\376\062" +
"\102\340\157\217\010\370\221\007\376\001\117\000\175\300\020\001" +
"\112\240\023\230\111\201\012\011\074\051\057\132\311\166\374\314" +
"\163\132\144\077\047\257\350\154\242\366\030\201\347\262\211\266" +
"\314\176\216\133\262\135\221\211\266\122\030\043\257\262\125\144" +
"\062\135\215\007\253\162\271\137\225\253\302\121\277\004\273\212" +
"\334\257\077\200\125\271\114\347\201\351\031\217\267\237\007\320" +
"\007\300\257\007\150\153\216\146\117\260\317\221\140\267\251\244" +
"\271\111\013\243\000\342\235\221\231\173\103\332\006\072\001\027" +
"\175\200\316\131\106\002\264\255\074\201\034\076\020\125\336\125" +
"\061\326\045\233\021\041\060\203\170\132\225\213\316\105\012\217" +
"\202\362\146\102\072\067\164\002\263\144\273\166\320\011\310\372" +
"\000\155\017\235\200\252\017\320\171\122\011\104\005\353\075\042" +
"\374\146\265\257\076\200\025\231\060\012\060\012\352\172\227\163" +
"\014\126\142\011\010\320\016\274\327\120\146\002\264\343\254\004" +
"\312\267\042\242\363\212\011\330\135\023\322\371\354\023\120\135" +
"\023\032\042\060\077\170\002\235\112\103\240\111\243\232\071\266" +
"\311\214\326\002\377\311\321\032\024\246\011\270\137\211\345\133" +
"\303\262\061\106\046\341\177\371\304\032\024\130\217\010\053\060" +
"\140\024\024\361\344\065\355\374\237\034\175\362\332\064\001\367" +
"\353\017\374\152\130\066\306\310\044\134\017\340\223\327\130\205" +
"\003\237\073\306\050\360\371\175\102\267\336\043\362\211\000\355" +
"\002\235\100\272\017\320\005\241\023\020\371\000\135\010\072\201" +
"\242\175\200\056\014\235\100\161\076\100\027\201\116\300\246\017" +
"\320\256\205\022\300\157\120\200\177\316\010\237\073\236\371\344" +
"\222\254\272\145\074\336\111\141\024\340\263\146\350\003\130\235" +
"\317\305\025\221\237\153\102\272\050\170\002\335\241\023\360\051" +
"\012\350\142\320\011\224\307\007\150\017\227\010\320\305\355\023" +
"\100\037\100\002\052\004\150\317\074\004\350\022\376\023\310\357" +
"\003\264\027\164\002\076\373\000\355\015\236\300\222\145\043\100" +
"\227\312\106\100\062\012\232\064\252\231\143\233\254\171\214\272" +
"\364\175\267\334\302\367\011\035\377\066\235\003\121\100\227\046" +
"\122\121\200\327\202\314\231\160\031\137\010\320\076\146\010\370" +
"\345\003\164\131\350\004\114\372\000\355\013\235\100\212\017\200" +
"\373\341\176\223\052\314\025\236\017\000\210\002\132\045\300\011" +
"\300\365\001\332\340\013\001\352\244\017\320\001\366\010\140\024" +
"\030\213\202\201\340\011\054\007\235\000\106\201\074\001\272\074" +
"\164\002\350\003\110\300\005\002\164\005\350\004\114\372\000\135" +
"\021\072\001\364\001\332\010\235\100\171\174\200\326\237\234\000" +
"\113\000\175\100\071\017\254\004\235\200\337\076\100\007\103\047" +
"\220\307\007\350\020\350\004\374\362\001\072\024\072\001\364\001" +
"\044\200\004\144\010\320\141\320\011\240\017\040\201\254\004\350" +
"\160\350\004\352\373\164\004\164\002\263\366\377\057\114\210\317" +
"\361\261\106\001\000"
});

public static void initArrays()
throws java.io.IOException,java.lang.ClassNotFoundException
{
    symbolNames = (String[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(symbolNamesHash);
    symbolDisplayNames = (String[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(symbolDisplayNamesHash);
    symbolNumbers = (int[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(symbolNumbersHash);
    productionLHSs = (int[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(productionLHSsHash);
    parseTable = (int[][]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(parseTableHash);
    shiftableSets = (java.util.BitSet[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(shiftableSetsHash);
    layoutSets = (java.util.BitSet[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(layoutSetsHash);
    prefixSets = (java.util.BitSet[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(prefixSetsHash);
    prefixMaps = (java.util.BitSet[][]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(prefixMapsHash);
    terminalUses = (int[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(terminalUsesHash);
    shiftableUnion = (java.util.BitSet) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(shiftableUnionHash);
    acceptSets = (java.util.BitSet[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(acceptSetsHash);
    rejectSets = (java.util.BitSet[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(rejectSetsHash);
    possibleSets = (java.util.BitSet[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(possibleSetsHash);
    cmap = (int[]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(cMapHash);
    delta = (int[][]) edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.readHash(deltaHash);
    }
public WyvernLexer() {}

		private static int TERMINAL_COUNT;
		private static int GRAMMAR_SYMBOL_COUNT;
		private static int SYMBOL_COUNT;
		private static int PARSER_STATE_COUNT;
		private static int SCANNER_STATE_COUNT;
		private static int DISAMBIG_GROUP_COUNT;
		
		private static int SCANNER_START_STATENUM;
		private static int PARSER_START_STATENUM;
		private static int EOF_SYMNUM;
		private static int EPS_SYMNUM;
		
		private static String[] symbolNames;
		private static String[] symbolDisplayNames;
		private static int[] symbolNumbers;
		private static int[] productionLHSs;
		
		private static int[][] parseTable;
		private static java.util.BitSet[] shiftableSets;
		private static java.util.BitSet[] layoutSets;
		private static java.util.BitSet[] prefixSets;
		private static java.util.BitSet[][] prefixMaps;
		private static int[] terminalUses;
		
		private static java.util.BitSet[] disambiguationGroups;
		
		private static java.util.BitSet shiftableUnion;
		
		private static java.util.BitSet[] acceptSets,rejectSets,possibleSets;
		
		private static int[][] delta;
		private static int[] cmap;
		
		public int getTERMINAL_COUNT() {
			return TERMINAL_COUNT;
		}
		public int getGRAMMAR_SYMBOL_COUNT() {
			return GRAMMAR_SYMBOL_COUNT;
		}
		public int getSYMBOL_COUNT() {
			return SYMBOL_COUNT;
		}
		public int getPARSER_STATE_COUNT() {
			return PARSER_STATE_COUNT;
		}
		public int getSCANNER_STATE_COUNT() {
			return SCANNER_STATE_COUNT;
		}
		public int getDISAMBIG_GROUP_COUNT() {
			return DISAMBIG_GROUP_COUNT;
		}
		public int getSCANNER_START_STATENUM() {
			return SCANNER_START_STATENUM;
		}
		public int getPARSER_START_STATENUM() {
			return PARSER_START_STATENUM;
		}
		public int getEOF_SYMNUM() {
			return EOF_SYMNUM;
		}
		public int getEPS_SYMNUM() {
			return EPS_SYMNUM;
		}
		public String[] getSymbolNames() {
			return symbolNames;
		}
		public String[] getSymbolDisplayNames() {
			return symbolDisplayNames;
		}
		public int[] getSymbolNumbers() {
			return symbolNumbers;
		}
		public int[] getProductionLHSs() {
			return productionLHSs;
		}
		public int[][] getParseTable() {
			return parseTable;
		}
		public java.util.BitSet[] getShiftableSets() {
			return shiftableSets;
		}
		public java.util.BitSet[] getLayoutSets() {
			return layoutSets;
		}
		public java.util.BitSet[] getPrefixSets() {
			return prefixSets;
		}
		public java.util.BitSet[][] getLayoutMaps() {
			return null;
		}
		public java.util.BitSet[][] getPrefixMaps() {
			return prefixMaps;
		}
		public int[] getTerminalUses() {
			return terminalUses;
		}
		public java.util.BitSet[] getDisambiguationGroups() {
			return disambiguationGroups;
		}
		public java.util.BitSet getShiftableUnion() {
			return shiftableUnion;
		}
		public java.util.BitSet[] getAcceptSets() {
			return acceptSets;
		}
		public java.util.BitSet[] getRejectSets() {
			return rejectSets;
		}
		public java.util.BitSet[] getPossibleSets() {
			return possibleSets;
		}
		public int[][] getDelta() {
			return delta;
		}
		public int[] getCmap() {
			return cmap;
		}	
    public List< Token > parse(java.io.Reader input,String inputName)
    throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
    {
    this.charBuffer = edu.umn.cs.melt.copper.runtime.io.ScannerBuffer.instantiate(input);
    setupEngine();
    startEngine(edu.umn.cs.melt.copper.runtime.io.InputPosition.initialPos(inputName));
    List< Token > parseTree = (List< Token >) runEngine();
    return parseTree;
    }


	/********************** LEXER STATE ************************/
	boolean foundTilde = false;						// is there a tilde ~ in the current line?
	boolean DSLNext = false;						// is the next line a DSL?
	boolean inDSL = false;							// are we in a DSL?
	Stack<String> indents = new Stack<String>();	// the stack of indents
	Token flagTok = null;							// a token that signals whether an indent is for a DSL
	boolean flagTokSet = false;        // did we set a flagTok while lexing the current line?
	Token lastIndent = null;
    public FileLocation startLocation = null;
    boolean ilineNext = false;                      // is the first iline in a sequence next?
    boolean isEQARROWlast = false;
    Stack<String> lambdas = new Stack<String>();	// the stack of indents for lambdas
    Stack<Stack<String>> metaStack = new Stack<Stack<String>>(); // the stack of indentation stacks, for handling multi-line lambdas correctly
	
	/********************** HELPER FUNCTIONS ************************/

    void adjustEQARROW(List list) {
        if (list.size() > 0) {
            Token t = (Token) list.get(list.size()-1);
            if (t.kind == EQARROW) {
                isEQARROWlast = true;
            } else if (t.kind != WHITESPACE && t.kind != SINGLE_LINE_COMMENT
                        && t.kind != MULTI_LINE_COMMENT) {
                isEQARROWlast = false;
            }
        }
    }
    
	/** equivalent (except for "if") to DSLNext */
	boolean isDSLNext() {
	    if (flagTok == null)
	    	return true;
		switch (flagTok.kind) {
		  case TILDE:
		  		return true;
		  case TYPE:
		  case DATATYPE:
		  case DEF:
		  case NEW:
		  case MATCH:
		  case EQARROW:
		  		return false;
		  default:
		  		throw new RuntimeException("broke invariant!");
		}
	}

	/** Wraps the lexeme s in a Token, setting the begin line/column and kind appropriately
	 *  The current lexical location is used.
	 */
	Token token(int kind, String s) {
		// Copper starts counting columns at 0, but we want to follow convention and count columns starting at 1
		int startLine = startLocation==null?1:startLocation.getLine();
        int startChar = startLocation==null?0:startLocation.getCharacter();
        return LexerUtils.makeToken(kind, s, virtualLocation.getLine()+startLine-1, virtualLocation.getColumn()+startChar+1);
	}

    /**
     * Find occurrences of escape sequences in the input string and replaces them with the
     * appropriate character.
     */
    String replaceEscapeSequences(String s) {
        StringBuilder new_s = new StringBuilder();

        int i;
        for (i = 0; i < s.length() - 1; ++i) {
            char c = s.charAt(i);

            if (c == '\\') {
                switch (s.charAt(i + 1)) {
                    case '\'':
                        c = '\''; ++i;
                        break;

                    case '\"':
                        c = '\"'; ++i;
                        break;

                    case '\\':
                        c = '\\'; ++i;
                        break;

                    case 'b':
                        c = '\b'; ++i;
                        break;

                    case 'f':
                        c = '\f'; ++i;
                        break;

                    case 'n':
                        c = '\n'; ++i;
                        break;

                    case 'r':
                        c = '\r'; ++i;
                        break;

                    case 't':
                        c = '\t'; ++i;
                        break;

                    case 'O':
                        int char_code = Integer.parseInt(Character.toString(s.charAt(i + 2)));
                        c = Character.toChars(char_code)[0];
                        i += 2;
                        break;

                    default:
                        ToolError.reportError(ErrorMessage.ILLEGAL_ESCAPE_SEQUENCE,
                                              new FileLocation(virtualLocation.getFileName(),
                                                               virtualLocation.getLine(),
                                                               virtualLocation.getColumn() + i + 2));
                }
            }

            new_s.append(c);
        }

        if (i < s.length()) {
            char c = s.charAt(i);
            if (c == '\\') {
                ToolError.reportError(ErrorMessage.UNCLOSED_STRING_LITERAL,
                                      new FileLocation(virtualLocation.getFileName(),
                                                       virtualLocation.getLine(),
                                                       virtualLocation.getColumn() + 1));
            }

            new_s.append(s.charAt(i));
        }

        return new_s.toString();
    }



    static
    {
        TERMINAL_COUNT = 81;
        GRAMMAR_SYMBOL_COUNT = 102;
        SYMBOL_COUNT = 205;
        PARSER_STATE_COUNT = 114;
        SCANNER_STATE_COUNT = 324;
        DISAMBIG_GROUP_COUNT = 4;
        SCANNER_START_STATENUM = 1;
        PARSER_START_STATENUM = 1;
        EOF_SYMNUM = 0;
        EPS_SYMNUM = -1;
        try { initArrays(); }
        catch(java.io.IOException ex) { ex.printStackTrace(); System.exit(1); }
        catch(java.lang.ClassNotFoundException ex) { ex.printStackTrace(); System.exit(1); }
        disambiguationGroups = new java.util.BitSet[4];
        disambiguationGroups[0] = newBitVec(81,30,43);
        disambiguationGroups[1] = newBitVec(81,36,55);
        disambiguationGroups[2] = newBitVec(81,36,44,55);
        disambiguationGroups[3] = newBitVec(81,41,80);
    }

}
