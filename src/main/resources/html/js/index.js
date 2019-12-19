
var initPagination = function (id, page, size, total) {
    var totalPages = Math.floor((total - 1) / size) + 1;
    var pagination = document.getElementById(id);
    // 小于等于8页的时候全部显示
    if (totalPages > 8 && page > 1) {
        var prev = document.createElement('a');
        prev.className = 'next page-numbers';
        prev.href = '?page=' + (page - 1);
        prev.innerText = '<上一页';
        pagination.append(prev);
    }
    for (var i = 1; i <= totalPages; i++) {
        if (i === page) {
            var span = document.createElement('span');
            span.className = 'page-numbers current';
            span.innerText = i;
            pagination.append(span);
        } else if ((i > 1) && (i < page - 2)) {
            var span = document.createElement('span');
            span.className = 'page-numbers dots';
            span.innerText = '…';
            pagination.append(span);
            i = page - 2 - 1;
        } else if ((i > page + 2) && (i < totalPages)) {
            var span = document.createElement('span');
            span.className = 'page-numbers dots';
            span.innerText = '…';
            pagination.append(span);
            i = totalPages - 1;
        } else {
            var a = document.createElement('a');
            a.className = 'page-numbers';
            a.href = '?page=' + i;
            a.innerText = i;
            pagination.append(a);
        }
    }
    if (totalPages > 8 && page < totalPages) {
        var next = document.createElement('a');
        next.className = 'next page-numbers';
        next.href = '?page=' + (page + 1);
        next.innerText = '下一页>';
        pagination.append(next);
    }
};

