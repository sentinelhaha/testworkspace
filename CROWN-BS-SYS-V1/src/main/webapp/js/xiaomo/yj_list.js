$(function () {

    $.get('http://192.168.2.38:8001/Django/yj_list/',{'sheng_name':'云南','pagination':$('#hidden_n').val()},function (data) {
        var n = 0;
        $('#hwslider>ul>li').each(function () {
            console.log(data.cs_lunbo[n],'---------1')
            $(this).html('<a href="#">' +
                             '<img src="'+data.http_dz+'/static/lunbo/'+data.cs_lunbo[n]+'"alt="">' +
                         '</a>');
            n++;
        });
        n = 0;
        $('#travel_list .col-md-4').each(function () {
            if(data.yj_list[n]){
                $(this).html('<a href="/news/?travel='+data.yj_list[n].id+'">' +
                                  '<img style="width: 100%;" src="'+data.http_dz+'/static/yj_tp/'+data.yj_list[n].img+'" class="img-responsive">' +
                                  '<h3>'+data.yj_list[n].yj_name+'</h3>' +
                             '</a>');
                n++;
            };
        });
        for(var i = 0;i < data.L.length; i++){
            if(i==0){
                if(data.L[i]==data.pagination[0]){
                    $('#pagination').append('<a href="javascript:;"><span>&nbsp;&nbsp;<b>上一页</b>&nbsp;&nbsp;</span></a>');
                }else{
                    $('#pagination').append('<a href="/yj_list/?pagination='+data.pagination[2]+'"><span>&nbsp;&nbsp;<b>上一页</b>&nbsp;&nbsp;</span></a>');
                };

            };

            if(data.L[i]==data.pagination[0]){
                $('#pagination').append('<a href="javascript:;"><span style="font-size: 20px;">&nbsp;&nbsp;<b>'+data.L[i]+'</b>&nbsp;&nbsp;</span></a>');
            }else{
                $('#pagination').append('<a href="/yj_list/?pagination='+data.L[i]+ '"><span>&nbsp;&nbsp;'+data.L[i]+'&nbsp;&nbsp;</span></a>');
            };

            if (i==data.L.length-1){
                if (data.L[i]==data.pagination[0]){
                    $('#pagination').append('<a href="javascript:;"><span>&nbsp;&nbsp;<b>下一页</b>&nbsp;&nbsp;</span></a>');
                }else{
                    $('#pagination').append('<a href="/yj_list/?pagination='+data.pagination[1]+'"><span>&nbsp;&nbsp;<b>下一页</b>&nbsp;&nbsp;</span></a>');
                };
            };
        };

    },'json');




    $("#hwslider").hwSlider({
        height: 190,
        autoPlay: true,
        arrShow: true,
        dotShow: true,
        touch: true
    });
    $("#hwslider1").hwSlider({
        height: 5,
        autoPlay: true,
        arrShow: true,
        dotShow: true,
        touch: true
    });

})