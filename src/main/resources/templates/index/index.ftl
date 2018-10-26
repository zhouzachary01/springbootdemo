<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/layui/layui.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/demo1/index/admin.css">
    <link rel="icon" href="/favicon.ico">
    <script type="text/javascript" src="js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="js/layui/layui.js"></script>
    <script src="js/demo1/index/index.js" data-main="home"></script>
    <title>ERP新手模式</title>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header custom-header">

        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item slide-sidebar" lay-unselect>
                <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
            </li>
        </ul>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">admin</a>
                <dl class="layui-nav-child">
                    <dd><a href="">帮助中心</a></dd>
                    <dd><a href="login.html">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side custom-admin">
        <div class="layui-side-scroll">

            <div class="custom-logo">
                <!-- <img src="assets/images/logo.png" alt=""/> -->
                <h1>ERP新手模式</h1>
            </div>
            <ul id="Nav" class="layui-nav layui-nav-tree">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe68e;</i>
                        <em>主页</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="views/annualplanningmeeting.html">年度规划会议</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe65e;</i>
                        <em>财务管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="views/check_cash.html">盘点现金</a></dd>
                        <dd><a href="views/balancesheet.html">查看资产负债表</a></dd>
                        <dd><a href="views/profit_sheet.html">查看利润表</a></dd>
                        <dd><a href="views/account.html">查看会计分录</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe62c;</i>
                        <em>市场预测</em>
                    </a>
                    <dl class="layui-nav-child">

                        <dd>
                        <dd><a href="views/forecast.html">市场预测</a></dd>

                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>广告投放&订单</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:">广告投放&订单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>原料管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:">查看库存</a></dd>
                        <dd><a href="javascript:">购买原料</a></dd>
                        <dd><a href="javascript:">查看原料采购单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>厂房管理&生产管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:">厂房管理</a></dd>
                        <dd><a href="javascript:">生产管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>产品研发&认证</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:">产品研发</a></dd>
                        <dd><a href="javascript:">认证管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>税金管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="views/taxmanger.html">税金管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>周期总结</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="views/timeManger/html/timeManger.html">本周期总结</a></dd>
                    </dl>
                </li>
            </ul>

        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
            <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
            <div id="appTabPage" class="layui-tab-content"></div>
        </div>
    </div>

    <div class="layui-footer">
        <p>© 2018 重庆邮电大学经济管理学院信管工作室</p>
    </div>

    <div class="mobile-mask"></div>
</div>

</body>
</html>
