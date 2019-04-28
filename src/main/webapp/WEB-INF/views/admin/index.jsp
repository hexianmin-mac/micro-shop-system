<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理系统</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/css/style.css">
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
    <script
            src="${pageContext.request.contextPath}/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script>
        (function ($) {
            $(window).load(
                function () {

                    $("a[rel='load-content']").click(
                        function (e) {
                            e.preventDefault();
                            var url = $(this).attr("href");
                            $.get(url, function (data) {
                                $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                                //scroll-to appended content
                                $(".content").mCustomScrollbar("scrollTo",
                                    "h2:last");
                            });
                        });

                    $(".content").delegate(
                        "a[href='top']",
                        "click",
                        function (e) {
                            e.preventDefault();
                            $(".content").mCustomScrollbar("scrollTo",
                                $(this).attr("href"));
                        });

                });
        })(jQuery);
    </script>
</head>
<body>
<!--header-->
<header>
    <h1>
        <img
                src="${pageContext.request.contextPath}/assets/images/admin_logo.png"/>
    </h1>
    <ul class="rt_nav">
        <li><a href="tzzup" class="set_icon">账号设置</a></li>

        <li><a href="tzlogin" class="quit_icon">安全退出</a></li>
    </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">

    <ul>
        <li>
            <dl>
                <dt>客户管理</dt>
                <!--当前链接则添加class:active-->
                <dd>
                    <a href="/user/homePage" class="active">客户列表</a>
                </dd>
                <dd>
                    <a href="/user/forwardUpdate">添加客户</a>
                </dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>货物管理</dt>
                <dd>
                    <a href="tzhw">货物列表</a>
                </dd>
                <dd>
                    <a href="tzkc">库存列表</a>
                </dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>入库管理</dt>
                <dd>
                    <a href="tzrk">新建入库单</a>
                </dd>
                <dd>
                    <a href="tzrksh">入库单审核</a>
                </dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>出库管理</dt>
                <dd>
                    <a href="tzck">新建出库单</a>
                </dd>
                <dd>
                    <a href="tzcksh">出库单审核</a>
                </dd>

            </dl>
        </li>
        <li>
            <dl>
                <dt>报表管理</dt>
                <dd>
                    <a href="tzbb">生成报表</a>
                </dd>
            </dl>
        </li>
    </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">客户列表</h2>
            <a href="tjyh" class="fr top_rt_btn add_icon">添加新客户</a>
        </div>
        <section class="mtb">
            <form action="sy" method="post">

                <input type="text" name="name" id="name" class="textbox textbox_225"
                       placeholder="输入用户账号"/> <input type="submit"
                                                     value="查询" class="group_btn"/>
            </form>
        </section>
        <table class="table">
            <tr>
                <th>Id</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>联系电话</th>
                <th>地址</th>
                <th>角色</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <tbody id="list">
            <c:forEach items="${userList}" var="user" varStatus="num">
                <tr>
                    <td id="id" class="center">${user.userId}</td>
                    <td id="name" class="center">${user.userName}</td>
                    <td id="sex" class="center">
                        <c:if test="${user.sex == 0}">
                            男
                        </c:if>
                        <c:if test="${user.sex == 1}">
                            女
                        </c:if>
                    </td>
                    <td id="age" class="center">${user.age}</td>
                    <td id="phone" class="center">${user.phone}</td>
                    <td id="address" class="center">${user.address}</td>
                    <td id="type" class="center">
                        <c:if test="${user.type == 0}">
                           客户
                        </c:if>
                        <c:if test="${user.type == 1}">
                            代理
                        </c:if>
                        <c:if test="${user.type == 2}">
                            客户
                        </c:if>
                        <c:if test="${user.type == 4}">
                            未分配
                        </c:if>
                    </td>
                    <td id="status" class="center">
                        <c:if test="${user.status == 0}">
                            正常
                        </c:if>
                        <c:if test="${user.status == 1}">
                            冻结
                        </c:if>
                    </td>
                        <%--<td id="t2" class="center"><c:if test="${list.t2 == 0}">--%>
                        <%--<a title="已验证" class="link_icon">&#89;</a>--%>
                        <%--</c:if> <c:if test="${list.t2 == 1}">--%>
                        <%--<a title="未验证" class="link_icon">&#88;</a>--%>
                        <%--</c:if></td>--%>
                    <td class="center">
                        <a href="tzup?id=${user.userId}" title="编辑" class="link_icon">&#101;
                        </a>
                        <a href="delete?id=${user.userId}" title="删除" class="link_icon">&#100;
                        </a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>

    </div>
</section>

</body>
</html>
