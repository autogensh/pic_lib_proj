var imgs = [
    '87058PICFreua6eFaTE4M_PIC2018.png',
    '92j58PICD58PICi74xh58PIC56JYh_PIC2018.jpg',
    '81x58PICzb3jby2dbcE5k_PIC2018.jpg',
    '44e58PICf2mfwGufKFq6e_PIC2018.jpg',
    '82G58PICqmcPv0cEafEf0_PIC2018.jpg',
    '73958PICUganU2kNqe71D_PIC2018.jpg',
    '38F58PIC8aF2fzHf6Rb75_PIC2018.jpg',
    '16T58PICaU7hufecEK9H6_PIC2018.jpg',
    '97M58PIC7kiG3A3bA313W_PIC2018.jpg',
    '43658PICDMYDVQrqgX7f8_PIC2018.jpg',
    '55s58PICbYS2ZHeh9d2dG_PIC2018.jpg',
    '97058PICbc4ie46M2x2vR_PIC2018.jpg',
    '31q58PICy6j64cc8u7Fw8_PIC2018.jpg',
    '00958PIC7Y780iRmd7IUC_PIC2018.jpg',
    '58PIC8358PICuf2vy20Chp358PICe_PIC2018.jpg',
    '38n58PICFbG58PICY7gcYb35p_PIC2018.jpg',
    '01958PICP58PICpy658PIC3t3VdVa_PIC2018.jpg',
    '50e58PICedWu0ZY258PICex6g_PIC2018.jpg',
    '3711_detail.jpg',
    '79258PICS61XK7BE8c5x3_PIC2018.jpg',
    '60458PICdCIQcqfdD985J_PIC2018.jpg',
    '54858PIC1SNI7Xy2ENuz7_PIC2018.jpg',
    '9533_detail.jpg'
];
var tpl = '<a href="/detail.html" target="_blank"><div class="mat_inner"><div class="mat_img"><img src="/images/dimen/{{IMG_URL}}"></div><div class="mat_detail">圣诞节礼品包装设计</div></div></a>';
var matList = document.getElementById('mat-list');
for (var i in imgs) {
    var newNode = document.createElement('div');
    newNode.className = 'mat';
    newNode.innerHTML = tpl.replace(/{{IMG_URL}}/, imgs[i]);
    matList.append(newNode);
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
