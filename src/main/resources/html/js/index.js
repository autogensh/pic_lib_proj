var imgs = [
    '81x58PICzb3jby2dbcE5k_PIC2018.jpg',
    '058PICm58PIC5aS633ytP2kFF_PIC2018.png',
    '81858PIC2dkb1dwbFHa4C_PIC2018.jpg',
    '04758PIC9Fn0C8R61rdq58PIC_PIC2018.jpg',
    '43k58PICzXH9xx6d3aQ5e_PIC2018.jpg',
    '88058PICcD1w58PICrx25z58PICWc_PIC2018.jpg',
    '56158PICv9sfVY289BdHd_PIC2018.png',
    '58m58PICd9Icf4fif7f5r_PIC2018.jpg',
    '05f58PICff3Uafaf9KfvG_PIC2018.jpg',
    '43658PICDMYDVQrqgX7f8_PIC2018.jpg',
    '43f58PIC7j8jT3xwx8CmC_PIC2018.jpg',
    '59K58PICV657dvC9NIcrx_PIC2018.jpg',
    '66058PIC5d7v02uDV87fd_PIC2018.png',
    '08i58PICeytd8d1wJazb1_PIC2018.jpg',
    '62b58PICDnGIE37cPbe7c_PIC2018.jpg',
    '14u58PIC295f2Wabf4X58PIC58PIC_PIC2018.jpg',
    '89858PIC79Y4H22Q58PIC9enj_PIC2018.jpg',
    '25h58PIC4RI3p7Gaa0wY3_PIC2018.jpg',
    '57N58PICeCeD7JKA6Byne_PIC2018.jpg',
    '69q58PIC1dSb333JajNa5_PIC2018.jpg'
];
var tpl = '<div class="mat"><div class="mat_inner"><div class="mat_img"><img src="/images/mat/{{IMG_URL}}"></div><div class="mat_detail">圣诞节礼品包装设计</div></div></div>';
var matlist = document.getElementById('matclean');
for (var i in imgs) {
    var newNode = document.createElement('div');
    newNode.innerHTML = tpl.replace(/{{IMG_URL}}/, imgs[i]);
    matlist.before(newNode);
}

var initPagination = function (id, page, size, total) {
    var totalPages = Math.floor((total - 1) / size) + 1;
    var pagination = document.getElementById(id);
    // 小于等于8页的时候全部显示
    if (totalPages > 8 && page > 1) {
        var prev = document.createElement('a');
        prev.className = 'prev page-numbers';
        prev.href = '#';
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
            span.className = 'page-numbers';
            span.innerText = '...';
            pagination.append(span);
            i = page - 2 - 1;
        } else if ((i > page + 2) && (i < totalPages)) {
            var span = document.createElement('span');
            span.className = 'page-numbers';
            span.innerText = '...';
            pagination.append(span);
            i = totalPages - 1;
        } else {
            var a = document.createElement('a');
            a.className = 'page-numbers';
            a.href = '#';
            a.innerText = i;
            pagination.append(a);
        }
    }
    if (totalPages > 8 && page < totalPages) {
        var next = document.createElement('a');
        next.className = 'next page-numbers';
        next.href = '#';
        next.innerText = '下一页>';
        pagination.append(next);
    }
};

initPagination('page', 1, 20, 200);
