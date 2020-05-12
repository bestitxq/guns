layui.use(['layer', 'form', 'table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 系统管理--消息管理
     */
    var Blog = {
        tableId: "blogTable"    //表格id
    };

    /**
     * 初始化表格的列
     */
    Blog.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'oId', align: "center", hide: true, sort: true, title: 'id'},
            {field: 'articleAbstractText', align: "center", sort: true, title: '标题'},
            {field: 'articleContent', align: "center", sort: true, title: '内容'},
            {field: 'createrName', align: "center", sort: true, title: '发布者'},
            {field: 'createTime', align: "center", sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作', minWidth: 200}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Blog.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Blog.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加通知
     */
    Blog.openAddBlog = function () {
        window.location.href = Feng.ctxPath + '/blog/blog_add';
    };

    /**
     * 点击编辑通知
     *
     * @param data 点击按钮时候的行数据
     */
    Blog.onEditBlog = function (data) {
        window.location.href = Feng.ctxPath + "/blog/blog_update?blogId=" + data.blogId;
    };

    /**
     * 点击删除通知
     *
     * @param data 点击按钮时候的行数据
     */
    Blog.onDeleteBlog = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/blog/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Blog.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("blogId", data.blogId);
            ajax.start();
        };
        Feng.confirm("是否删除通知 " + data.title + "?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Blog.tableId,
        url: Feng.ctxPath + '/blog/list',
        page: true,
        height: "full-98",
        cellMinWidth: 100,
        cols: Blog.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Blog.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Blog.openAddBlog();
    });

    // 工具条点击事件
    table.on('tool(' + Blog.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Blog.onEditBlog(data);
        } else if (layEvent === 'delete') {
            Blog.onDeleteBlog(data);
        }
    });
});
