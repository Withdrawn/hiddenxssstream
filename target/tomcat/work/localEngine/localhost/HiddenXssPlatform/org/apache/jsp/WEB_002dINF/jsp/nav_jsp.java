package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class nav_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>Document</title>\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"favicon.jpg\" type=\"image/x-icon\">\r\n");
      out.write("\t\r\n");
      out.write("\t<style>\r\n");
      out.write("\tbody,div,ul,li,a,img{margin:0; padding: 0;}\r\n");
      out.write("\thtml{font-size: 62.5%;}\r\n");
      out.write("\tbody{font-family: \"Open Sans\", Arial, \"Hiragino Sans GB\", \"Microsoft YaHei\", \"微软雅黑\", \"STHeiti\", \"WenQuanYi Micro Hei\", SimSun, sans-serif}\r\n");
      out.write("\t.fix{position: fixed; top: 0; border-bottom: none !important ;background: #fefefe;box-shadow: 0 1px 3px rgba(0,0,0,0.2); height:80px; width:100%;}\r\n");
      out.write("\t .scrolled { background: #fefefe; box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2) }\r\n");
      out.write("\t .navinner{width:980px; height:60px; margin: 0 auto; padding-top: 10px;}\r\n");
      out.write("\t .navinner ul{list-style-type: none; width: 980px; height: 60px;}\r\n");
      out.write("\t .navinner li{width: 100px; height: 60px; float: left;}\r\n");
      out.write("\t .navinner li a{width: 100px; height:60px; display: block; line-height:60px; float: left; font-size:2rem; text-decoration: none; color: #51aded; font-weight: bolder; text-align: center;}\r\n");
      out.write("\t #logo{float: left; margin-right:50px;}\r\n");
      out.write("\t #sddm div\r\n");
      out.write("\t{\t\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tvisibility: hidden;\r\n");
      out.write("\r\n");
      out.write("\t\theight: auto;\r\n");
      out.write("\t\twidth: 100px;\r\n");
      out.write("\t\tbackground: #EAEBD8;\r\n");
      out.write("\t\tborder: 1px solid #5970B2;\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\tfilter:Alpha(opacity=50);\r\n");
      out.write("\t}\r\n");
      out.write("\t#sddm div a\r\n");
      out.write("\t{\r\n");
      out.write("\t\theight:30px; width: 100px;\r\n");
      out.write("\t\tfont-size: 14px;\r\n");
      out.write("\t\tline-height: 30px;\r\n");
      out.write("\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script>\r\n");
      out.write("\twindow.onscroll = function(){ \r\n");
      out.write("\t    var t = document.documentElement.scrollTop || document.body.scrollTop;  \r\n");
      out.write("\t    var top_div = document.getElementById( \"fix\" ); \r\n");
      out.write("\t \r\n");
      out.write("\t   \tif(t>0&&top_div.className.indexOf(\"scrolled\")==-1)\r\n");
      out.write("\t   \t{\r\n");
      out.write("\t   \t\ttop_div.className+=' scrolled';\r\n");
      out.write("\t   \t}else if(t==0){top_div.className='fix';}\r\n");
      out.write("\t} \r\n");
      out.write("\tvar ddmenuitem=0;\r\n");
      out.write("\tvar timeout=1500;\r\n");
      out.write("\tvar closetimer= 0;\r\n");
      out.write("\tfunction mopen(id)\r\n");
      out.write("\t{\t\r\n");
      out.write("\t\tddmenuitem = document.getElementById(id);\r\n");
      out.write("\t\tddmenuitem.style.visibility = 'visible';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"aux\").innerHTML=\"辅&nbsp;助▼\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction mclose()\r\n");
      out.write("\t{\r\n");
      out.write("\t\t\t//var order=event.srcElement||event.taget;  \r\n");
      out.write("\t\t\t//\tif(order.tagName!='A')\r\n");
      out.write("\t\t\t//\t{ onmouselevel代替out   level会把事件对象内当一个整体\r\n");
      out.write("\t\t\t\t//\t}\r\n");
      out.write("\t\t\tif(ddmenuitem) \r\n");
      out.write("\t\t\t\tddmenuitem.style.visibility = 'hidden';\r\n");
      out.write("\t\t\tdocument.getElementById(\"aux\").innerHTML=\"辅&nbsp;助◄\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction mclosetime()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tclosetimer = window.setTimeout(mclose, timeout);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction mcancelclosetime()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(closetimer)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\twindow.clearTimeout(closetimer);\r\n");
      out.write("\t\t\tclosetimer = null;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"fix\" class=\"fix\">\r\n");
      out.write("\t\t<div class=\"navinner\">\r\n");
      out.write("\t\t\t<span id=\"logo\">\r\n");
      out.write("\t\t\t\t<img src=\"images/logo.png\" alt=\"HiddenXss\">\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t\t<ul id=\"sddm\">\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0)\">首&nbsp;页</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0)\">记&nbsp;忆</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0)\">小知识</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0)\">寻访利器</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"aa\" id=\"aux\" onmouseover=\"mopen('m1')\"  onmouseout=\"mclosetime()\">辅&nbsp;助◄</a>\r\n");
      out.write("\t\t\t\t\t<div id=\"m1\" onmouseover=\"mcancelclosetime()\" onmouseleave=\"mclose()\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"short\">短域名</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">社工库</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">加解密</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">笔记</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" ></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0)\">吃货榜</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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
