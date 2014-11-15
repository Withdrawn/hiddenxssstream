package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class projectcode_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/c.tld");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>项目</title>\r\n");
      out.write("\t<style>\r\n");
      out.write("\ttable,h3,body,caption,div,td,tr,textarea{margin:0;padding:0;}\r\n");
      out.write("\tspan{\r\n");
      out.write("\t\t background-color: #F8F8F8;\r\n");
      out.write("\t    border: 1px solid #CCCCCC;\r\n");
      out.write("\t    color: #333333;\r\n");
      out.write("\t    display: block;\r\n");
      out.write("\t    font-family: Lucida Console,Courier New,Courier,mono,monospace;\r\n");
      out.write("\t    font-size: 12px;\r\n");
      out.write("\t    line-height: 18px;\r\n");
      out.write("\t    margin: 0 auto;\r\n");
      out.write("\t    overflow: auto;\r\n");
      out.write("\t    padding: 4px 8px;\r\n");
      out.write("\t    word-wrap: break-word;\r\n");
      out.write("\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t\t<h3>项目名称:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.p_title }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t<label>项目代码:</label>\r\n");
      out.write("\t\t\t<span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allcode}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<label>如何使用：</label>\r\n");
      out.write("\t\t<p>将如下代码植入怀疑出现xss的地方（注意'的转义），即可在 <a href=\"");
      out.print(basePath);
      out.write("/project/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.p_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">项目内容</a> 观看XSS效果。</p>\r\n");
      out.write("\t\t<span>\r\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${codeshow1 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("或者\r\n");
      out.write("</p>\r\n");
      out.write("<p>\r\n");
      out.write("<span>\r\n");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${codeshow2 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("</span>\r\n");
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("<p>\r\n");
      out.write("再或者以你任何想要的方式插入\r\n");
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("<p>\r\n");
      out.write("<span>\r\n");
      out.print(basePath);
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.p_urlkey}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("</span>\r\n");
      out.write("</p>\r\n");
      out.write("<p>\r\n");
      out.write("参数接收地址\r\n");
      out.write("<br/>\r\n");
      out.write("<span>\r\n");
      out.print(basePath);
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.p_urlkey}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/rec?参数1=xx&参数2=yy\r\n");
      out.write("</span>\r\n");
      out.write("</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
