/* ArchParser.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. ArchParser.java */
package wyvern.tools.parsing.coreparser.arch;


import wyvern.tools.parsing.coreparser.TokenManager;
import wyvern.tools.parsing.coreparser.Token;
import wyvern.tools.parsing.coreparser.ParseException;

public class ArchParser/*@bgen(jjtree)*/implements ArchParserTreeConstants, ArchParserConstants {/*@bgen(jjtree)*/
  protected JJTArchParserState jjtree = new JJTArchParserState();
    public String fname;
    public static String kindToName(int kind) {
      switch (kind) {
      case MULTI_LINE_COMMENT: return "MULTI_LINE_COMMENT";
      case COMMA: return "COMMA";
      case ATTACHMENTS: return "ATTACHMENTS";
      case IS: return "IS";
      case BINDINGS: return "BINDINGS";
      case ENTRYPOINTS: return "ENTRYPOINTS";
      case CONNECT: return "CONNECT";
      case DOT: return "DOT";
      case AND: return "AND";
      case WITH: return "WITH";
      case CONNECTORS: return "CONNECTORS";
      case COMPONENTS: return "COMPONENTS";
      case ARCHITECTURE: return "ARCHITECTURE";
      case VAL: return "VAL";
      case CONNECTOR: return "CONNECTOR";
      case COMPONENT: return "COMPONENT";
      case PORT: return "PORT";
      case COLON: return "COLON";
      case IDENTIFIER: return "IDENTIFIER";
      case WHITESPACE: return "WHITESPACE";
      case DEDENT: return "DEDENT";
      case INDENT: return "INDENT";
      case NEWLINE: return "NEWLINE";
      case PROVIDES: return "PROVIDES";
      case REQUIRES: return "REQUIRES";
      default: return "UNKNOWN(" + kind + ")";
      }
    }

/** Root production. */
  final public SimpleNode ArchDesc() throws ParseException {/*@bgen(jjtree) ArchDesc */
  ASTArchDesc jjtn000 = new ASTArchDesc(JJTARCHDESC);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      ArchTypeDeclSeq();
jjtn000.setLocation(fname, 0, 0);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public void ArchTypeDeclSeq() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMPONENT:
    case EXTERNAL:
    case CONNECTOR:
    case ARCHITECTURE:{
      ArchTypeDecls();
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMPONENT:
        case EXTERNAL:
        case CONNECTOR:
        case ARCHITECTURE:{
          ;
          break;
          }
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        ArchTypeDecls();
      }
      break;
      }
    case 0:{
      jj_consume_token(0);
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ArchTypeDecls() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMPONENT:
    case EXTERNAL:{
      ComponentTypeDecl();
      break;
      }
    case CONNECTOR:{
      ConnectorTypeDecl();
      break;
      }
    case ARCHITECTURE:{
      ArchitectureTypeDecl();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ComponentTypeDecl() throws ParseException {/*@bgen(jjtree) ComponentTypeDecl */
  ASTComponentTypeDecl jjtn000 = new ASTComponentTypeDecl(JJTCOMPONENTTYPEDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token name;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case EXTERNAL:{
        jj_consume_token(EXTERNAL);
jjtn000.setExternal(true);
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      jj_consume_token(COMPONENT);
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      ComponentTypeDeclBody();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMPONENT:
        case EXTERNAL:
        case PORT:
        case CONNECTOR:
        case VAL:
        case ARCHITECTURE:
        case BINDINGS:{
          ;
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          break label_2;
        }
        ComponentTypeDeclBody();

      }
      jj_consume_token(DEDENT);
jjtn000.setTypeName(name.image);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void ComponentTypeDeclBody() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PORT:
    case VAL:{
      MemberDecls();
      break;
      }
    case COMPONENT:
    case EXTERNAL:
    case CONNECTOR:
    case ARCHITECTURE:{
      ArchTypeDecls();
      break;
      }
    case BINDINGS:{
      BindingDecls();
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ConnectorTypeDecl() throws ParseException {/*@bgen(jjtree) ConnectorTypeDecl */
  ASTConnectorTypeDecl jjtn000 = new ASTConnectorTypeDecl(JJTCONNECTORTYPEDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token name;
    try {
      jj_consume_token(CONNECTOR);
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      ValDecl();
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case VAL:{
          ;
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          break label_3;
        }
        ValDecl();
      }
      jj_consume_token(DEDENT);
jjtn000.setTypeName(name.image);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

/*Errors*/
  final public void ArchitectureTypeDecl() throws ParseException {/*@bgen(jjtree) ArchitectureTypeDecl */
  ASTArchitectureTypeDecl jjtn000 = new ASTArchitectureTypeDecl(JJTARCHITECTURETYPEDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token name;
    try {
      jj_consume_token(ARCHITECTURE);
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      ArchElemDeclSeq();
      jj_consume_token(DEDENT);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.setTypeName(name.image);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void ArchElemDeclSeq() throws ParseException {
    ArchElemDecls();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMPONENTS:
      case CONNECTORS:
      case ATTACHMENTS:
      case ENTRYPOINTS:{
        ;
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      ArchElemDecls();
    }
  }

  final public void ArchElemDecls() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMPONENTS:{
      ComponentDecls();
      break;
      }
    case CONNECTORS:{
      ConnectorDecls();
      break;
      }
    case ATTACHMENTS:{
      AttachmentDecls();
      break;
      }
    case ENTRYPOINTS:{
      EntryPointDecls();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ComponentDecls() throws ParseException {
    jj_consume_token(COMPONENTS);
    jj_consume_token(NEWLINE);
    jj_consume_token(INDENT);
    ComponentDeclAux();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:
      case IDENTIFIER:{
        ;
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
      ComponentDeclAux();
    }
    jj_consume_token(DEDENT);
  }

  final public void ComponentDeclAux() throws ParseException {String type = null;
    type = ComponentDecl("");
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:
      case IDENTIFIER:{
        ;
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      ComponentDecl(type);
    }
    jj_consume_token(NEWLINE);
  }

  final public String ComponentDecl(String t) throws ParseException {/*@bgen(jjtree) ComponentDecl */
  ASTComponentDecl jjtn000 = new ASTComponentDecl(JJTCOMPONENTDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token type; Token name;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:{
        type = jj_consume_token(IDENTIFIER);
        name = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                                              jjtc000 = false;
jjtn000.setType(type.image);
                                              jjtn000.setName(name.image);
                                              jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
                                              {if ("" != null) return type.image;}
        break;
        }
      case COMMA:{
        jj_consume_token(COMMA);
        name = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                                              jjtc000 = false;
jjtn000.setType(t);
                                              jjtn000.setName(name.image);
                                              jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
                                              {if ("" != null) return t;}
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public void ConnectorDecls() throws ParseException {
    jj_consume_token(CONNECTORS);
    jj_consume_token(NEWLINE);
    jj_consume_token(INDENT);
    ConnectorDeclAux();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:
      case IDENTIFIER:{
        ;
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        break label_7;
      }
      ConnectorDeclAux();
    }
    jj_consume_token(DEDENT);
  }

  final public void ConnectorDeclAux() throws ParseException {String type = null;
    type = ConnectorDecl("");
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:
      case IDENTIFIER:{
        ;
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        break label_8;
      }
      ConnectorDecl(type);
    }
    jj_consume_token(NEWLINE);
  }

  final public String ConnectorDecl(String t) throws ParseException {/*@bgen(jjtree) ConnectorDecl */
  ASTConnectorDecl jjtn000 = new ASTConnectorDecl(JJTCONNECTORDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token type; Token name;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:{
        type = jj_consume_token(IDENTIFIER);
        name = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                                              jjtc000 = false;
jjtn000.setType(type.image);
                                              jjtn000.setName(name.image);
                                              jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
                                              {if ("" != null) return type.image;}
        break;
        }
      case COMMA:{
        jj_consume_token(COMMA);
        name = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                                              jjtc000 = false;
jjtn000.setType(t);
                                              jjtn000.setName(name.image);
                                              jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
                                              {if ("" != null) return t;}
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public void AttachmentDecls() throws ParseException {
    jj_consume_token(ATTACHMENTS);
    jj_consume_token(NEWLINE);
    jj_consume_token(INDENT);
    jj_consume_token(CONNECT);
    AttachmentDecl();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:{
        ;
        break;
        }
      default:
        jj_la1[15] = jj_gen;
        break label_9;
      }
      AttachmentDecl();
    }
    jj_consume_token(DEDENT);
  }

  final public void AttachmentDecl() throws ParseException {/*@bgen(jjtree) AttachmentDecl */
  ASTAttachmentDecl jjtn000 = new ASTAttachmentDecl(JJTATTACHMENTDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);String p1; String p2; Token cntr;
    try {
      p1 = Segment();
      jj_consume_token(AND);
      p2 = Segment();
jjtn000.addPort(p1); jjtn000.addPort(p2);
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case AND:{
          ;
          break;
          }
        default:
          jj_la1[16] = jj_gen;
          break label_10;
        }
        jj_consume_token(AND);
        p2 = Segment();
jjtn000.addPort(p2);
      }
      jj_consume_token(WITH);
      cntr = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
jjtn000.setConnector(cntr.image);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.setLocation(fname, cntr.beginLine, cntr.beginColumn);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void BindingDecls() throws ParseException {
    jj_consume_token(BINDINGS);
    jj_consume_token(NEWLINE);
    jj_consume_token(INDENT);
    BindingDecl();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:{
        ;
        break;
        }
      default:
        jj_la1[17] = jj_gen;
        break label_11;
      }
      BindingDecl();
    }
    jj_consume_token(DEDENT);
  }

/*Errors?*/
  final public void BindingDecl() throws ParseException {/*@bgen(jjtree) BindingDecl */
  ASTBindingDecl jjtn000 = new ASTBindingDecl(JJTBINDINGDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token name; String target;
    try {
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(IS);
      target = Segment();
      jj_consume_token(NEWLINE);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.setName(name.image);
      jjtn000.setTarget(target);
      jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void EntryPointDecls() throws ParseException {
    jj_consume_token(ENTRYPOINTS);
    jj_consume_token(NEWLINE);
    jj_consume_token(INDENT);
    EntryPointDecl();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:{
        ;
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        break label_12;
      }
      EntryPointDecl();
    }
    jj_consume_token(DEDENT);
  }

/*Errors?*/
  final public void EntryPointDecl() throws ParseException {/*@bgen(jjtree) EntryPointDecl */
  ASTEntryPointDecl jjtn000 = new ASTEntryPointDecl(JJTENTRYPOINTDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token name; Token action;
    try {
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      action = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.setName(name.image);
      jjtn000.setAction(action.image);
      jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void MemberDecls() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case VAL:{
      ValDecl();
      break;
      }
    case PORT:{
      PortDecl();
      break;
      }
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*Errors?*/
  final public void PortDecl() throws ParseException {/*@bgen(jjtree) PortDecl */
  ASTPortDecl jjtn000 = new ASTPortDecl(JJTPORTDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token p; Token req ; Token prov ; Token startMark;
    try {
      jj_consume_token(PORT);
      p = jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case REQUIRES:{
        jj_consume_token(REQUIRES);
        req = jj_consume_token(IDENTIFIER);
jjtn000.setRequires(req.image);
        break;
        }
      case PROVIDES:{
        jj_consume_token(PROVIDES);
        prov = jj_consume_token(IDENTIFIER);
jjtn000.setProvides(prov.image);
        break;
        }
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(NEWLINE);
jjtn000.setPort(p.image);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.setLocation(fname, p.beginLine, p.beginColumn);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

/*Errors?*/
  final public void ValDecl() throws ParseException {/*@bgen(jjtree) ValDecl */
  ASTValDecl jjtn000 = new ASTValDecl(JJTVALDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t; Token name; Token startMark;
    try {
      jj_consume_token(VAL);
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      t = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
jjtn000.setName(name.image);
      jjtn000.setType(t.image);
      jjtn000.setLocation(fname, name.beginLine, name.beginColumn);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public String Segment() throws ParseException {String s; Token t;
    t = jj_consume_token(IDENTIFIER);
s = t.image;
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case DOT:{
        ;
        break;
        }
      default:
        jj_la1[21] = jj_gen;
        break label_13;
      }
      jj_consume_token(DOT);
      t = jj_consume_token(IDENTIFIER);
s = s + "." + t.image;
    }
{if ("" != null) return s;}
    throw new Error("Missing return statement in function");
  }

  /** User defined Token Manager. */
  public TokenManager token_source;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x146,0x147,0x146,0x4,0x101ce,0x101ce,0x80,0x8e00,0x8e00,0x8100000,0x8100000,0x8100000,0x8100000,0x8100000,0x8100000,0x8000000,0x2000,0x8000000,0x8000000,0x88,0x30,0x80000,};
   }


  /** Constructor with user supplied Token Manager. */
  public ArchParser(TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 22; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}