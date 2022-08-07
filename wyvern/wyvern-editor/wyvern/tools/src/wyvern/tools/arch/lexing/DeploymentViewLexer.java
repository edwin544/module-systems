/*
 * Built at Mon Jul 04 18:11:08 NZST 2022
 * by Copper version 0.7.1,
 *      revision unknown,
 *      build 20140605-2206
 */
package wyvern.tools.arch.lexing;

import static wyvern.tools.parsing.coreparser.arch.views.deployment.DeploymentViewParserConstants.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import wyvern.tools.errors.ErrorMessage;
import wyvern.tools.errors.FileLocation;
import wyvern.tools.errors.ToolError;
import wyvern.tools.lexing.LexerUtils;
import wyvern.tools.parsing.coreparser.arch.views.deployment.DeploymentViewParserConstants;
import wyvern.tools.parsing.coreparser.Token;



public class DeploymentViewLexer extends edu.umn.cs.melt.copper.runtime.engines.single.SingleDFAEngine<List< Token >,edu.umn.cs.melt.copper.runtime.logging.CopperParserException>
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
        comment_t(1),
        continue_line_t(2),
        deploymentKwd_t(3),
        dot_t(4),
        equals_t(5),
        extendsKwd_t(6),
        identifier_t(7),
        indent_t(8),
        multi_comment_t(9),
        newline_t(10),
        stringLiteral_t(11),
        whitespace_t(12);

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
            case 24:
                RESULT = runSemanticAction_24();
                break;
            case 25:
                RESULT = runSemanticAction_25();
                break;
            case 26:
                RESULT = runSemanticAction_26();
                break;
            case 27:
                RESULT = runSemanticAction_27();
                break;
            case 28:
                RESULT = runSemanticAction_28();
                break;
            case 29:
                RESULT = runSemanticAction_29();
                break;
            case 30:
                RESULT = runSemanticAction_30();
                break;
            case 31:
                RESULT = runSemanticAction_31();
                break;
            case 32:
                RESULT = runSemanticAction_32();
                break;
            case 33:
                RESULT = runSemanticAction_33();
                break;
            case 34:
                RESULT = runSemanticAction_34();
                break;
            case 35:
                RESULT = runSemanticAction_35();
                break;
            case 36:
                RESULT = runSemanticAction_36();
                break;
            case 37:
                RESULT = runSemanticAction_37();
                break;
            case 38:
                RESULT = runSemanticAction_38();
                break;
            case 39:
                RESULT = runSemanticAction_39();
                break;
            case 40:
                RESULT = runSemanticAction_40();
                break;
            case 41:
                RESULT = runSemanticAction_41();
                break;
            case 42:
                RESULT = runSemanticAction_42();
                break;
            case 43:
                RESULT = runSemanticAction_43();
                break;
            case 44:
                RESULT = runSemanticAction_44();
                break;
            case 45:
                RESULT = runSemanticAction_45();
                break;
            case 46:
                RESULT = runSemanticAction_46();
                break;
            case 47:
                RESULT = runSemanticAction_47();
                break;
            case 48:
                RESULT = runSemanticAction_48();
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
            default:
        runDefaultTermAction();
                 break;
            }
            return RESULT;
        }
        public List< Token > runSemanticAction_24()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_25()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > n = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = n; 
            return RESULT;
        }
        public Token runSemanticAction_26()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_27()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public List< Token > runSemanticAction_28()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > list = (List< Token >) _children[0];
            @SuppressWarnings("unchecked") List< Token > n = (List< Token >) _children[1];
            List< Token > RESULT = null;
             list.addAll(n); RESULT = list; 
            return RESULT;
        }
        public List< Token > runSemanticAction_29()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_30()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > n = (List< Token >) _children[0];
            List< Token > RESULT = null;
            
                                // handles lines that start without any indent
                                RESULT = n;
                            
            return RESULT;
        }
        public List< Token > runSemanticAction_31()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > line = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = line; 
            return RESULT;
        }
        public List< Token > runSemanticAction_32()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[0];
            @SuppressWarnings("unchecked") List< Token > line = (List< Token >) _children[1];
            List< Token > RESULT = null;
             p.addAll(line); RESULT = p; 
            return RESULT;
        }
        public Token runSemanticAction_33()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public List< Token > runSemanticAction_34()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > list = (List< Token >) _children[0];
            Token n = (Token) _children[1];
            List< Token > RESULT = null;
            
                        list.add(n);
                        RESULT = LexerUtils.<DeploymentViewParserConstants>adjustLogicalLine((LinkedList<Token>)list,
                                            virtualLocation.getFileName(), indents,
                                            DeploymentViewParserConstants.class);
                    
            return RESULT;
        }
        public List< Token > runSemanticAction_35()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_36()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_37()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_38()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token n = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(n); 
            return RESULT;
        }
        public List< Token > runSemanticAction_39()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public List< Token > runSemanticAction_40()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public List< Token > runSemanticAction_41()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public List< Token > runSemanticAction_42()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            List< Token > RESULT = null;
             RESULT = LexerUtils.makeList(t); 
            return RESULT;
        }
        public Token runSemanticAction_43()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public Token runSemanticAction_44()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token t = (Token) _children[0];
            Token RESULT = null;
             RESULT = t; 
            return RESULT;
        }
        public List< Token > runSemanticAction_45()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[0];
            List< Token > RESULT = null;
            
                    RESULT = p;
                    Token t = ((LinkedList<Token>)p).getLast();
                    RESULT.addAll(LexerUtils.<DeploymentViewParserConstants>possibleDedentList(
                        t, virtualLocation.getFileName(), indents, DeploymentViewParserConstants.class));
                
            return RESULT;
        }
        public List< Token > runSemanticAction_46()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > p = (List< Token >) _children[0];
            @SuppressWarnings("unchecked") List< Token > list = (List< Token >) _children[1];
            List< Token > RESULT = null;
            
                    // handle the case of ending in an incomplete line
                    RESULT = p;
                    List<Token> adjustedList = LexerUtils.<DeploymentViewParserConstants>adjustLogicalLine(
                        (LinkedList<Token>)list, virtualLocation.getFileName(),
                         indents, DeploymentViewParserConstants.class);
                    RESULT.addAll(adjustedList);
                    Token t = ((LinkedList<Token>)adjustedList).getLast();
                    RESULT.addAll(LexerUtils.<DeploymentViewParserConstants>possibleDedentList(
                        t, virtualLocation.getFileName(), indents, DeploymentViewParserConstants.class));
                
            return RESULT;
        }
        public List< Token > runSemanticAction_47()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            @SuppressWarnings("unchecked") List< Token > list = (List< Token >) _children[0];
            List< Token > RESULT = null;
             RESULT = list; 
            return RESULT;
        }
        public List< Token > runSemanticAction_48()
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            List< Token > RESULT = null;
             RESULT = LexerUtils.emptyList(); 
            return RESULT;
        }
        public Token runSemanticAction_1(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(SINGLE_LINE_COMMENT, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_2(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_3(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DEPLOYMENT, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_4(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(DOT, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_5(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(EQUALS, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_6(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(EXTENDS, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_7(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
        RESULT = token(IDENTIFIER, lexeme);
 	
            return RESULT;
        }
        public Token runSemanticAction_8(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_9(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(MULTI_LINE_COMMENT, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_10(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE, lexeme); 
            return RESULT;
        }
        public Token runSemanticAction_11(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
            
 		    RESULT = token(STRING_LITERAL, replaceEscapeSequences(lexeme.substring(1,lexeme.length()-1)));
 	    
            return RESULT;
        }
        public Token runSemanticAction_12(final String lexeme)
        throws edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            Token RESULT = null;
             RESULT = token(WHITESPACE, lexeme); 
            return RESULT;
        }
        public int runDisambiguationAction(edu.umn.cs.melt.copper.runtime.io.InputPosition _pos,edu.umn.cs.melt.copper.runtime.engines.single.scanner.SingleDFAMatchData match)
        throws java.io.IOException,edu.umn.cs.melt.copper.runtime.logging.CopperParserException
        {
            return -1;
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
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\125\220\115\116\303\060" +
"\020\205\107\100\241\025\025\040\165\315\025\052\234\226\122\304" +
"\212\105\141\101\045\020\251\140\301\042\262\022\023\014\216\155" +
"\234\011\151\305\225\340\062\134\002\261\340\016\070\236\362\267" +
"\171\057\236\274\367\171\344\227\117\150\125\016\172\067\323\173" +
"\376\304\373\212\353\274\037\243\223\072\077\172\175\273\172\377" +
"\330\175\076\135\001\230\133\000\140\010\253\223\363\023\204\116" +
"\152\212\102\150\114\020\141\073\065\032\245\256\104\242\244\026" +
"\141\222\011\253\314\242\011\234\325\131\063\151\145\046\144\333" +
"\342\261\342\252\154\076\273\142\216\102\147\345\062\321\225\231" +
"\217\313\133\051\134\010\112\235\175\363\213\112\241\114\376\334" +
"\330\321\242\376\271\253\014\253\116\045\012\307\125\040\325\167" +
"\376\120\132\236\206\100\053\236\035\137\316\020\266\270\136\114" +
"\175\151\242\104\303\101\330\170\020\213\332\270\014\241\247\176" +
"\347\261\337\120\350\124\370\142\063\055\175\116\021\033\141\123" +
"\231\134\246\134\065\030\204\035\155\364\165\374\017\331\066\326" +
"\047\321\070\337\262\316\344\216\027\010\353\141\201\013\204\265" +
"\304\106\003\262\041\031\043\213\202\261\075\377\272\211\035\007" +
"\075\014\072\014\272\117\051\372\075\012\172\100\015\352\263\145" +
"\237\330\214\330\214\132\154\104\266\054\214\311\210\116\100\026" +
"\064\012\072\370\002\124\341\134\200\014\002\000\000"
});

public static final byte[] symbolDisplayNamesHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\125\216\115\116\303\060" +
"\020\205\247\205\212\126\124\200\304\232\035\353\012\267\245\024" +
"\261\106\054\350\256\022\054\220\032\131\311\020\014\216\155\234" +
"\011\151\305\225\340\062\134\002\261\340\016\070\236\362\267\171" +
"\057\236\274\367\315\274\174\102\247\362\260\177\063\273\227\117" +
"\162\240\245\311\007\163\362\312\344\147\257\157\127\357\037\007" +
"\317\027\155\200\245\003\000\101\320\072\044\350\245\266\050\320" +
"\120\102\004\273\251\065\244\114\205\211\126\006\343\044\103\247" +
"\355\252\011\134\326\131\063\351\144\066\146\273\370\130\111\135" +
"\066\237\175\134\022\232\254\134\047\372\052\013\161\165\253\320" +
"\307\240\062\331\067\277\250\064\251\344\317\306\236\301\372\147" +
"\127\031\017\235\051\102\057\165\044\325\167\341\121\072\231\306" +
"\100\153\101\260\043\315\152\026\012\347\032\033\006\301\326\003" +
"\256\152\353\063\202\175\375\073\237\207\353\320\244\030\356\155" +
"\246\145\310\151\346\022\154\153\233\253\124\352\006\103\260\147" +
"\254\271\236\377\103\166\255\013\111\262\076\264\234\267\271\227" +
"\005\101\173\021\266\157\046\156\070\142\033\263\011\266\141\064" +
"\161\104\260\221\270\151\324\323\250\343\250\307\234\342\337\223" +
"\250\047\334\340\276\130\367\231\055\230\055\270\045\046\154\353" +
"\302\224\215\351\014\024\121\207\121\107\137\161\062\130\277\002" +
"\002\000\000"
});

public static final byte[] symbolNumbersHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\201\051\332\323\167\127\202\132\331\253\115\113\231\030\030" +
"\052\012\030\030\030\014\031\310\000\012\104\142\007\006\006\046" +
"\040\146\104\303\350\142\114\070\304\011\141\230\172\006\000\010" +
"\161\363\013\337\000\000\000"
});

public static final byte[] productionLHSsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\201\051\332\323\167\127\202\132\331\253\115\113\231\030\030" +
"\052\012\030\030\030\244\024\030\030\170\201\230\017\212\371\241" +
"\130\000\011\013\102\261\020\020\013\103\261\010\036\054\012\305" +
"\142\310\030\000\362\140\251\244\203\000\000\000"
});

public static final byte[] parseTableHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\275\224\273\116\002\121" +
"\020\206\047\213\170\005\105\121\227\005\057\307\033\336\057\017" +
"\140\141\113\141\174\200\155\170\004\065\301\130\331\133\371\024" +
"\164\126\226\076\217\225\211\265\255\377\306\331\104\062\144\334" +
"\237\104\117\362\005\370\262\234\057\263\305\074\177\110\271\167" +
"\053\245\064\355\304\237\157\127\311\323\343\171\044\162\177\055" +
"\042\055\370\050\355\134\276\166\333\167\357\057\375\134\307\362" +
"\207\247\167\043\017\022\145\225\013\221\263\040\022\201\022\030" +
"\003\145\060\016\046\300\044\230\002\323\140\006\124\176\336\202" +
"\337\125\060\013\346\100\015\314\203\005\120\007\213\003\225\035" +
"\217\354\266\141\216\236\145\327\103\053\306\321\225\246\207\126" +
"\214\243\053\207\036\132\061\216\256\034\171\150\305\070\272\322" +
"\362\320\212\161\164\145\333\103\053\306\321\225\125\017\255\030" +
"\107\127\332\036\132\061\216\256\154\061\024\055\230\312\206\207" +
"\316\142\034\135\071\360\320\212\161\164\345\064\070\333\062\173" +
"\072\174\157\313\045\120\001\313\352\142\120\315\157\304\367\232" +
"\176\066\100\335\124\216\275\112\370\175\047\047\171\005\064\203" +
"\356\144\123\331\367\320\067\146\034\375\306\326\031\212\026\114" +
"\145\315\103\147\061\216\256\354\171\150\305\070\256\322\055\372" +
"\227\021\316\300\054\233\014\043\127\032\036\331\323\303\034\135" +
"\131\361\320\212\161\164\045\361\320\212\161\164\345\044\374\307" +
"\206\011\014\105\347\310\316\027\005\042\275\042\353\012\000\000" +
""
});

public static final byte[] shiftableSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\203\164\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\140\144\200\202\212\342\102\206\072\006\246\122\020" +
"\311\212\220\340\377\217\103\102\156\270\113\320\303\347\244\333" +
"\101\105\127\061\060\016\306\070\007\132\016\000\336\347\164\304" +
"\003\003\000\000"
});

public static final byte[] layoutSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\203\164\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\140\144\200\202\212\342\102\206\072\006\246\122\020" +
"\311\072\052\061\052\061\160\022\000\322\322\001\215\003\003\000" +
"\000"
});

public static final byte[] prefixSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\203\164\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\140\144\200\202\212\342\102\206\072\006\246\122\020" +
"\311\072\052\061\052\061\160\022\000\322\322\001\215\003\003\000" +
"\000"
});

public static final byte[] prefixMapsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\044\072\332\047\053\261\054\121\257\264\044\063\107\317" +
"\051\263\044\070\265\304\132\362\322\273\215\346\317\356\030\061" +
"\061\060\124\024\060\060\060\110\003\025\012\143\121\227\053\251" +
"\301\162\276\317\245\000\246\216\267\000\031\224\026\062\324\061" +
"\060\215\012\217\012\123\123\030\000\302\213\160\316\270\002\000" +
"\000"
});

public static final byte[] terminalUsesHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\201\051\332\323\167\127\202\132\331\253\115\113\231\030\030" +
"\052\012\030\030\030\170\031\310\000\000\132\346\100\064\117\000" +
"\000\000"
});

public static final byte[] shiftableUnionHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\270" +
"\210\101\040\053\261\054\121\257\264\044\063\107\317\051\263\044" +
"\070\265\044\357\157\107\235\245\311\152\105\146\006\306\150\006" +
"\226\244\314\222\342\022\006\246\150\257\212\202\322\042\060\255" +
"\300\262\125\150\143\351\144\046\006\206\212\002\006\006\006\106" +
"\006\060\220\377\137\001\000\210\341\156\002\121\000\000\000"
});

public static final byte[] acceptSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\203\135\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\140\250\050\056\144\250\143\140\052\005\221\254\330" +
"\004\030\031\040\100\000\227\104\003\016\011\101\234\106\051\220" +
"\152\024\013\361\316\304\060\202\260\126\134\146\141\332\112\276" +
"\227\051\367\031\007\371\036\041\042\120\050\260\004\247\255\114" +
"\270\044\130\110\226\040\043\126\211\367\021\135\054\241\145\260" +
"\221\357\160\152\146\027\046\222\023\077\065\045\034\350\140\007" +
"\107\005\000\356\202\362\376\236\005\000\000"
});

public static final byte[] rejectSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\203\135\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\140\250\050\056\144\250\143\140\052\005\221\254\243" +
"\002\243\002\243\002\103\122\200\221\001\002\032\250\152\026\000" +
"\266\153\111\021\216\004\000\000"
});

public static final byte[] possibleSetsHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\101\070\332\047\053\261\054\121\257\264\044\063\107\317\051" +
"\263\044\070\265\304\072\127\122\203\345\174\237\113\001\023\003" +
"\103\105\001\003\003\203\135\161\021\203\000\272\252\274\277\035" +
"\165\226\046\253\025\231\031\030\243\031\130\222\062\113\212\113" +
"\030\230\242\275\052\012\200\206\202\150\005\226\255\102\033\113" +
"\047\303\314\140\250\050\056\144\250\143\140\052\005\221\254\100" +
"\076\043\003\030\310\377\303\041\301\040\200\113\242\001\207\204" +
"\040\056\073\030\024\160\111\034\300\041\301\202\313\050\016\234" +
"\166\164\220\252\203\211\011\227\121\054\244\272\212\214\040\241" +
"\236\317\251\050\101\172\040\122\121\202\011\247\253\110\216\050" +
"\334\022\270\202\175\344\206\056\065\203\235\172\241\113\305\260" +
"\042\303\347\270\374\201\323\125\164\321\101\216\004\000\376\202" +
"\220\172\146\006\000\000"
});

public static final byte[] cMapHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\355\316\111\116\002\101" +
"\024\000\320\262\001\231\034\230\005\017\340\135\134\170\002\067" +
"\036\301\230\100\270\220\073\127\054\071\022\011\167\340\167\302" +
"\242\122\061\322\262\176\225\274\124\375\374\251\176\216\251\263" +
"\376\112\325\373\353\333\376\343\145\163\330\175\127\051\155\077" +
"\323\115\252\317\163\003\255\060\317\342\176\303\276\246\263\353" +
"\373\356\227\334\070\173\257\212\134\375\373\151\170\272\140\171" +
"\226\367\166\212\270\272\322\350\237\365\365\256\131\261\267\334" +
"\377\030\272\177\314\130\204\166\350\205\333\060\310\162\303\360" +
"\120\324\117\302\175\266\013\000\000\000\000\000\000\000\000\000" +
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
"\000\000\000\000\056\072\001\154\276\333\337\033\000\004\000"
});

public static final byte[] deltaHash = edu.umn.cs.melt.copper.runtime.auxiliary.internal.ByteArrayEncoder.literalToByteArray
(new String[]{ "\037\213\010\000\000\000\000\000\000\377\133\363\226\201\265\264" +
"\210\201\071\072\332\123\374\373\023\177\311\376\116\033\046\006" +
"\206\212\002\006\006\006\073\240\070\123\264\247\357\256\004\265" +
"\262\127\233\226\302\204\245\031\350\010\112\013\031\352\030\230" +
"\220\154\005\261\231\201\230\005\112\263\102\151\066\050\315\016" +
"\245\101\230\003\211\315\011\245\271\240\064\067\020\363\000\061" +
"\057\224\217\337\126\272\000\254\266\362\141\241\371\260\360\321" +
"\345\320\365\061\140\121\203\333\126\020\340\047\317\027\304\201" +
"\141\024\302\002\150\226\020\037\302\324\002\202\330\004\061\154" +
"\025\042\001\013\023\220\027\001\142\121\154\162\104\207\260\030" +
"\003\055\323\260\070\205\130\002\211\055\011\304\122\330\324\321" +
"\054\136\145\160\210\203\355\041\331\126\131\022\155\227\303\046" +
"\070\214\362\353\120\052\021\111\365\253\074\026\061\144\100\377" +
"\262\011\053\030\104\145\023\315\001\206\255\012\024\140\105\054" +
"\142\130\315\304\260\125\224\004\254\104\100\136\031\227\034\131" +
"\151\130\005\207\334\110\055\375\361\002\014\133\125\051\300\152" +
"\130\304\260\232\211\141\253\024\205\130\035\211\255\201\113\035" +
"\206\255\232\064\306\132\040\032\303\126\155\002\230\030\065\004" +
"\325\323\074\065\351\140\023\034\044\151\030\004\260\225\022\272" +
"\014\270\153\072\312\113\211\201\251\163\150\145\253\036\136\133" +
"\351\002\060\154\325\247\062\306\152\046\135\332\210\006\014\203" +
"\263\316\241\225\255\206\170\155\245\013\300\260\325\210\312\030" +
"\253\231\203\244\316\061\246\022\066\301\047\077\114\153\072\254" +
"\200\244\122\302\024\215\217\314\036\212\165\316\340\151\373\233" +
"\341\010\125\352\205\360\300\224\303\043\251\075\114\027\100\265" +
"\132\335\034\213\076\006\064\065\370\107\103\110\261\325\002\207" +
"\074\155\154\265\304\042\107\035\133\255\210\360\053\365\155\245" +
"\126\153\215\174\133\255\007\314\257\066\003\142\053\056\277\332" +
"\016\210\255\044\373\025\000\002\310\355\350\275\034\000\000"
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
public DeploymentViewLexer() {}

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


    /*************************** LEXER  STATE ***************************/
    Stack<String> indents = new Stack<String>();

    /************************* HELPER FUNCTIONS *************************/

	/** Wraps the lexeme s in a Token, setting the begin line/column and kind appropriately
	 *  The current lexical location is used.
	 */
	Token token(int kind, String s) {
		// Copper starts counting columns at 0, but we want to follow convention and count columns starting at 1
		return LexerUtils.makeToken(kind, s, virtualLocation.getLine(), virtualLocation.getColumn()+1);
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
        TERMINAL_COUNT = 13;
        GRAMMAR_SYMBOL_COUNT = 23;
        SYMBOL_COUNT = 49;
        PARSER_STATE_COUNT = 27;
        SCANNER_STATE_COUNT = 62;
        DISAMBIG_GROUP_COUNT = 1;
        SCANNER_START_STATENUM = 1;
        PARSER_START_STATENUM = 1;
        EOF_SYMNUM = 0;
        EPS_SYMNUM = -1;
        try { initArrays(); }
        catch(java.io.IOException ex) { ex.printStackTrace(); System.exit(1); }
        catch(java.lang.ClassNotFoundException ex) { ex.printStackTrace(); System.exit(1); }
        disambiguationGroups = new java.util.BitSet[1];
    }

}
