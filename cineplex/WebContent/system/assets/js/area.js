function ChangeSelect(obj){
  var n = obj.selectedIndex; //获取第一个列表中选中的项的序列
  var val = obj.options[n].value;  //获取第一个列表中选择的项的值
  if(val==1){  //如果选择的值是 2 

                document.info_form.city.options.length = 21; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("东城区",1);
                document.info_form.city.options[2]=new Option("西城区",2);
                document.info_form.city.options[3]=new Option("崇文区",3);
                document.info_form.city.options[4]=new Option("宣武区",4);
                document.info_form.city.options[5]=new Option("朝阳区",5);
                document.info_form.city.options[6]=new Option("丰台区",6);
                document.info_form.city.options[7]=new Option("石景山区",7);
                document.info_form.city.options[8]=new Option("海淀区",8);
                document.info_form.city.options[9]=new Option("门头沟区",9);
                document.info_form.city.options[10]=new Option("房山区",10);
                document.info_form.city.options[11]=new Option("通州区",11);
                document.info_form.city.options[12]=new Option("顺义区",12);
                document.info_form.city.options[13]=new Option("昌平区",13);
                document.info_form.city.options[14]=new Option("大兴区",14);
                 document.info_form.city.options[15]=new Option("怀柔区",15);
                  document.info_form.city.options[16]=new Option("大兴区",16);
                   document.info_form.city.options[17]=new Option("平谷区",17);
                    document.info_form.city.options[18]=new Option("密云县",18);
                     document.info_form.city.options[19]=new Option("延庆县",19);
                       document.info_form.city.options[20]=new Option("其他",20);
}

  if(val==2){  //如果选择的值是 2 

                document.info_form.city.options.length = 16; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("和平区",1);
                document.info_form.city.options[2]=new Option("河东区",2);
                document.info_form.city.options[3]=new Option("河西区",3);
                document.info_form.city.options[4]=new Option("南开区",4);
                document.info_form.city.options[5]=new Option("红桥区",5);
                document.info_form.city.options[6]=new Option("塘沽区",6);
                document.info_form.city.options[7]=new Option("汉沽区",7);
                document.info_form.city.options[8]=new Option("大港区",8);
                document.info_form.city.options[9]=new Option("西青区",9);
                document.info_form.city.options[10]=new Option("津南区",10);
                document.info_form.city.options[11]=new Option("武清区",11);
                document.info_form.city.options[12]=new Option("蓟县",12);
                document.info_form.city.options[13]=new Option("宁河县",13);
                document.info_form.city.options[14]=new Option("静海县",14);
                 document.info_form.city.options[15]=new Option("其他",15);
}

  if(val==3){  //如果选择的值是 2 
                document.info_form.city.options.length = 13; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("石家庄市",1);
                document.info_form.city.options[2]=new Option("张家口市",2);
                document.info_form.city.options[3]=new Option("承德市",3);
                document.info_form.city.options[4]=new Option("秦皇岛市",4);
                document.info_form.city.options[5]=new Option("唐山市",5);
                document.info_form.city.options[6]=new Option("廊坊市",6);
                document.info_form.city.options[7]=new Option("衡水市",7);
                document.info_form.city.options[8]=new Option("沧州市",8);
                document.info_form.city.options[9]=new Option("邢台市",9);
                document.info_form.city.options[10]=new Option("邯郸市",10);
                document.info_form.city.options[11]=new Option("保定市",11);
                document.info_form.city.options[12]=new Option("其他",12);
              
}

  if(val==4){  //如果选择的值是 2 
                document.info_form.city.options.length = 12; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("太原市",1);
                document.info_form.city.options[2]=new Option("朔州市",2);
                document.info_form.city.options[3]=new Option("大同市",3);
                document.info_form.city.options[4]=new Option("长治市",4);
                document.info_form.city.options[5]=new Option("晋城市",5);
                document.info_form.city.options[6]=new Option("忻州市",6);
                document.info_form.city.options[7]=new Option("晋中市",7);
                document.info_form.city.options[8]=new Option("临汾市",8);
                document.info_form.city.options[9]=new Option("吕梁市",9);
                document.info_form.city.options[10]=new Option("运城市",10);
                document.info_form.city.options[11]=new Option("其他",11);
}

  if(val==5){  //如果选择的值是 2 

                document.info_form.city.options.length = 12; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("呼和浩特市",1);
                document.info_form.city.options[2]=new Option("包头市",2);
                document.info_form.city.options[3]=new Option("赤峰市",3);
                document.info_form.city.options[4]=new Option("呼伦贝尔市",4);
                document.info_form.city.options[5]=new Option("鄂尔多斯市",5);
                document.info_form.city.options[6]=new Option("乌兰察布市",6);
                document.info_form.city.options[7]=new Option("巴彦淖尔市",7);
                document.info_form.city.options[8]=new Option("兴安盟",8);
                document.info_form.city.options[9]=new Option("阿拉善盟",9);
                document.info_form.city.options[10]=new Option("锡林郭勒盟",10);
                document.info_form.city.options[11]=new Option("其他",11);
}

  if(val==6){  //如果选择的值是 2 

                document.info_form.city.options.length = 16; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("沈阳市",1);
                document.info_form.city.options[2]=new Option("朝阳市",2);
                document.info_form.city.options[3]=new Option("阜新市",3);
                document.info_form.city.options[4]=new Option("铁岭市",4);
                document.info_form.city.options[5]=new Option("抚顺市",5);
                document.info_form.city.options[6]=new Option("丹东市",6);
                document.info_form.city.options[7]=new Option("本溪市",7);
                document.info_form.city.options[8]=new Option("辽宁市",8);
                document.info_form.city.options[9]=new Option("鞍山市",9);
                document.info_form.city.options[10]=new Option("大连市",10);
                document.info_form.city.options[11]=new Option("营口市",11);
                document.info_form.city.options[12]=new Option("盘锦市",12);
                document.info_form.city.options[13]=new Option("锦州市",13);
                document.info_form.city.options[14]=new Option("葫芦岛市",14);
                document.info_form.city.options[15]=new Option("其他",15);
}

 if(val==7){  //如果选择的值是 2 

                document.info_form.city.options.length = 10; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("长春市",1);
                document.info_form.city.options[2]=new Option("白城市",2);
                document.info_form.city.options[3]=new Option("吉林市",3);
                document.info_form.city.options[4]=new Option("四平市",4);
                document.info_form.city.options[5]=new Option("辽源市",5);
                document.info_form.city.options[6]=new Option("通化市",6);
                document.info_form.city.options[7]=new Option("白山市",7);
                document.info_form.city.options[8]=new Option("延边朝鲜族自治州",8);
                document.info_form.city.options[9]=new Option("其他",9);
}

 if(val==8){ //如果选择的值是 2 

                document.info_form.city.options.length = 15; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("哈尔滨市",1);
                document.info_form.city.options[2]=new Option("七台河市",2);
                document.info_form.city.options[3]=new Option("黑河市",3);
                document.info_form.city.options[4]=new Option("大庆市",4);
                document.info_form.city.options[5]=new Option("齐齐哈尔市",5);
                document.info_form.city.options[6]=new Option("伊春市",6);
                document.info_form.city.options[7]=new Option("佳木斯市",7);
                document.info_form.city.options[8]=new Option("双鸭山市",8);
                document.info_form.city.options[9]=new Option("鸡西市",9);
                document.info_form.city.options[10]=new Option("大兴安岭地区(加格达奇)",10);
                document.info_form.city.options[11]=new Option("牡丹江",11);
                document.info_form.city.options[12]=new Option("鹤岗市",12);
                document.info_form.city.options[13]=new Option("绥化市",13);
                document.info_form.city.options[14]=new Option("其他",14);
}
  if(val==9){  //如果选择的值是 2 

                document.info_form.city.options.length = 20; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("黄浦区",1);
                document.info_form.city.options[2]=new Option("卢湾区",2);
                document.info_form.city.options[3]=new Option("徐汇区",3);
                document.info_form.city.options[4]=new Option("长宁区",4);
                document.info_form.city.options[5]=new Option("静安区",5);
                document.info_form.city.options[6]=new Option("普陀区",6);
                document.info_form.city.options[7]=new Option("闸北区",7);
                document.info_form.city.options[8]=new Option("虹口区",8);
                document.info_form.city.options[9]=new Option("杨浦区",9);
                document.info_form.city.options[10]=new Option("闵行区",10);
                document.info_form.city.options[11]=new Option("宝山区",11);
                document.info_form.city.options[12]=new Option("嘉定区",12);
                document.info_form.city.options[13]=new Option("浦东新区",13);
                document.info_form.city.options[14]=new Option("金山区",14);
                document.info_form.city.options[15]=new Option("松江区",15);
                document.info_form.city.options[16]=new Option("青浦区",16);
                document.info_form.city.options[17]=new Option("南汇区",17);
                document.info_form.city.options[18]=new Option("崇明县",18);
                document.info_form.city.options[19]=new Option("其他",19);
}

 if(val==10){  //如果选择的值是 2 
                document.info_form.city.options.length = 15; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("南京市",1);
                document.info_form.city.options[2]=new Option("徐州市",2);
                document.info_form.city.options[3]=new Option("连云港市",3);
                document.info_form.city.options[4]=new Option("宿迁市",4);
                document.info_form.city.options[5]=new Option("淮安市",5);
                document.info_form.city.options[6]=new Option("盐城市",6);
                document.info_form.city.options[7]=new Option("扬州市",7);
                document.info_form.city.options[8]=new Option("泰州市",8);
                document.info_form.city.options[9]=new Option("南通市",9);
                document.info_form.city.options[10]=new Option("镇江市",10);
                document.info_form.city.options[11]=new Option("常州市",11);
                document.info_form.city.options[12]=new Option("无锡市",12);
                document.info_form.city.options[13]=new Option("苏州市",13);
                document.info_form.city.options[14]=new Option("其他",14);

}

if(val==11){  //如果选择的值是 2 

                document.info_form.city.options.length = 13; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("杭州市",1);
                document.info_form.city.options[2]=new Option("湖州市",2);
                document.info_form.city.options[3]=new Option("嘉兴市",3);
                document.info_form.city.options[4]=new Option("舟山市",4);
                document.info_form.city.options[5]=new Option("宁波市",5);
                document.info_form.city.options[6]=new Option("绍兴市",6);
                document.info_form.city.options[7]=new Option("衢州市",7);
                document.info_form.city.options[8]=new Option("金华市",8);
                document.info_form.city.options[9]=new Option("台州市",9);
                document.info_form.city.options[10]=new Option("温州市",10);
                document.info_form.city.options[11]=new Option("丽水市",11);
                document.info_form.city.options[12]=new Option("其他",12);

}
if(val==12){  //如果选择的值是 2 

                document.info_form.city.options.length = 19; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("合肥市",1);
                document.info_form.city.options[2]=new Option("宿州市",2);
                document.info_form.city.options[3]=new Option("淮北市",3);
                document.info_form.city.options[4]=new Option("亳州市",4);
                document.info_form.city.options[5]=new Option("阜阳市",5);
                document.info_form.city.options[6]=new Option("蚌埠市",6);
                document.info_form.city.options[7]=new Option("淮南市",7);
                document.info_form.city.options[8]=new Option("滁州市",8);
                document.info_form.city.options[9]=new Option("马鞍山市",9);
                document.info_form.city.options[10]=new Option("芜湖市",10);
                document.info_form.city.options[11]=new Option("铜陵市",11);
                document.info_form.city.options[12]=new Option("安庆市",12);
                document.info_form.city.options[13]=new Option("黄山市",13);
                document.info_form.city.options[14]=new Option("六安市",14);
                document.info_form.city.options[15]=new Option("巢湖市",15);
                document.info_form.city.options[16]=new Option("池州市",16);
                document.info_form.city.options[17]=new Option("宣州市",17);
                document.info_form.city.options[18]=new Option("其他",18);
}

if(val==13){  //如果选择的值是 2 

                document.info_form.city.options.length = 11; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("福州市",1);
                document.info_form.city.options[2]=new Option("南平市",2);
                document.info_form.city.options[3]=new Option("莆田市",3);
                document.info_form.city.options[4]=new Option("三明市",4);
                document.info_form.city.options[5]=new Option("泉州市",5);
                document.info_form.city.options[6]=new Option("厦门市",6);
                document.info_form.city.options[7]=new Option("漳州市",7);
                document.info_form.city.options[8]=new Option("龙岩市",8);
                document.info_form.city.options[9]=new Option("宁德市",9);
                document.info_form.city.options[10]=new Option("其他",10);
                
}

if(val==14){  //如果选择的值是 2 

                document.info_form.city.options.length = 13; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("南昌市",1);
                document.info_form.city.options[2]=new Option("九江市",2);
                document.info_form.city.options[3]=new Option("景德镇市",3);
                document.info_form.city.options[4]=new Option("鹰潭市",4);
                document.info_form.city.options[5]=new Option("新余市",5);
                document.info_form.city.options[6]=new Option("萍乡市",6);
                document.info_form.city.options[7]=new Option("赣州市",7);
                document.info_form.city.options[8]=new Option("上饶市",8);
                document.info_form.city.options[9]=new Option("抚州市",9);
                document.info_form.city.options[10]=new Option("宜春市",10);
                document.info_form.city.options[11]=new Option("吉安市",11);
                document.info_form.city.options[12]=new Option("其他",12);
}


if(val==15){  //如果选择的值是 2 
 
                document.info_form.city.options.length = 19; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("济南市",1);
                document.info_form.city.options[2]=new Option("聊城市",2);
                document.info_form.city.options[3]=new Option("德州市",3);
                document.info_form.city.options[4]=new Option("东营市",4);
                document.info_form.city.options[5]=new Option("淄博市",5);
                document.info_form.city.options[6]=new Option("潍坊市",6);
                document.info_form.city.options[7]=new Option("烟台市",7);
                document.info_form.city.options[8]=new Option("威海市",8);
                document.info_form.city.options[9]=new Option("青岛市",9);
                document.info_form.city.options[10]=new Option("日照市",10);
                document.info_form.city.options[11]=new Option("临沂市",11);
                document.info_form.city.options[12]=new Option("枣庄市",12);
                document.info_form.city.options[13]=new Option("济宁市",13);
                document.info_form.city.options[14]=new Option("泰安市",14);
                document.info_form.city.options[15]=new Option("莱芜市",15);
                document.info_form.city.options[16]=new Option("滨州市",16);
                document.info_form.city.options[17]=new Option("菏泽市",17);
                document.info_form.city.options[18]=new Option("其他",18);
}


if(val==16){  //如果选择的值是 2 

                document.info_form.city.options.length = 19; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("郑州市",1);
                document.info_form.city.options[2]=new Option("三门峡市",2);
                document.info_form.city.options[3]=new Option("洛阳市",3);
                document.info_form.city.options[4]=new Option("焦作市",4);
                document.info_form.city.options[5]=new Option("新乡市",5);
                document.info_form.city.options[6]=new Option("鹤壁市",6);
                document.info_form.city.options[7]=new Option("安阳市",7);
                document.info_form.city.options[8]=new Option("濮阳市",8);
                document.info_form.city.options[9]=new Option("开封市",9);
                document.info_form.city.options[10]=new Option("商丘市",10);
                document.info_form.city.options[11]=new Option("许昌市",11);
                document.info_form.city.options[12]=new Option("漯河市",12);
                document.info_form.city.options[13]=new Option("平顶山市",13);
                document.info_form.city.options[14]=new Option("南阳市",14);
                document.info_form.city.options[15]=new Option("信阳市",15);
                document.info_form.city.options[16]=new Option("周口市",16);
                document.info_form.city.options[17]=new Option("驻马店市",17);
                document.info_form.city.options[18]=new Option("其他",18);
}

if(val==17){  //如果选择的值是 2 

                document.info_form.city.options.length = 16; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("武汉市",1);
                document.info_form.city.options[2]=new Option("十堰市",2);
                document.info_form.city.options[3]=new Option("襄樊市",3);
                document.info_form.city.options[4]=new Option("荆门市",4);
                document.info_form.city.options[5]=new Option("孝感市",5);
                document.info_form.city.options[6]=new Option("黄冈市",6);
                document.info_form.city.options[7]=new Option("鄂州市",7);
                document.info_form.city.options[8]=new Option("黄石市",8);
                document.info_form.city.options[9]=new Option("咸宁市",9);
                document.info_form.city.options[10]=new Option("荆州市",10);
                document.info_form.city.options[11]=new Option("宜昌市",11);
                document.info_form.city.options[12]=new Option("随州市",12);
                document.info_form.city.options[13]=new Option("恩施土家族苗族自治州",13);
                document.info_form.city.options[14]=new Option("仙桃市",14);
                document.info_form.city.options[15]=new Option("天门市",15);
                document.info_form.city.options[16]=new Option("潜江市",16);
                document.info_form.city.options[17]=new Option("神农架林区",17);
                document.info_form.city.options[18]=new Option("其他",18);
}
if(val==18){  //如果选择的值是 2 

                document.info_form.city.options.length = 10; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("长沙市",1);
                document.info_form.city.options[2]=new Option("张家界市",2);
                document.info_form.city.options[3]=new Option("常德市",3);
                document.info_form.city.options[4]=new Option("益阳市",4);
                document.info_form.city.options[5]=new Option("岳阳市",5);
                document.info_form.city.options[6]=new Option("株洲市",6);
                document.info_form.city.options[7]=new Option("湘潭市",7);
                document.info_form.city.options[8]=new Option("衡阳市",8);
                document.info_form.city.options[9]=new Option("郴州市",9);
                document.info_form.city.options[10]=new Option("永州市",10);
                document.info_form.city.options[11]=new Option("邵阳市",11);
                document.info_form.city.options[12]=new Option("怀化市",12);
                document.info_form.city.options[13]=new Option("娄底市",13);
                document.info_form.city.options[14]=new Option("湘西土家族苗族自治州",14);
                document.info_form.city.options[15]=new Option("其他",15);
           
}

if(val==19){  //如果选择的值是 2 

             document.info_form.city.options.length = 23; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("广州市",1);
                document.info_form.city.options[2]=new Option("清远市",2);
                document.info_form.city.options[3]=new Option("韶关市",3);
                document.info_form.city.options[4]=new Option("河源市",4);
                document.info_form.city.options[5]=new Option("梅州市",5);
                document.info_form.city.options[6]=new Option("潮州市",6);
                document.info_form.city.options[7]=new Option("汕头市",7);
                document.info_form.city.options[8]=new Option("揭阳市",8);
                document.info_form.city.options[9]=new Option("汕尾市",9);
                document.info_form.city.options[10]=new Option("惠州市",10);
                document.info_form.city.options[11]=new Option("东莞市",11);
                document.info_form.city.options[12]=new Option("深圳市",12);
                document.info_form.city.options[13]=new Option("珠海市",13);
                document.info_form.city.options[14]=new Option("中山市",14);
                document.info_form.city.options[15]=new Option("江门市",15);
                document.info_form.city.options[16]=new Option("佛山市",16);
                document.info_form.city.options[17]=new Option("肇庆市",17);
                document.info_form.city.options[18]=new Option("云浮市",18);
                document.info_form.city.options[19]=new Option("阳江市",19);
                document.info_form.city.options[20]=new Option("茂名市",20);
                document.info_form.city.options[21]=new Option("湛江市",21);
                document.info_form.city.options[22]=new Option("其他",22);
           
                
               
           
}

if(val==20){  //如果选择的值是 2 

                document.info_form.city.options.length = 16; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("南宁市",1);
                document.info_form.city.options[2]=new Option("桂林市",2);
                document.info_form.city.options[3]=new Option("柳州市",3);
                document.info_form.city.options[4]=new Option("梧州市",4);
                document.info_form.city.options[5]=new Option("贵港市",5);
                document.info_form.city.options[6]=new Option("玉林市",6);
                document.info_form.city.options[7]=new Option("钦州市",7);
                document.info_form.city.options[8]=new Option("北海市",8);
                document.info_form.city.options[9]=new Option("防城港市",9);
                document.info_form.city.options[10]=new Option("崇左市",10);
                document.info_form.city.options[11]=new Option("百色市",11);
                document.info_form.city.options[12]=new Option("河池市",12);
                document.info_form.city.options[13]=new Option("来宾市",13);
                document.info_form.city.options[14]=new Option("贺州市",14);
                document.info_form.city.options[15]=new Option("其他",15);
            
}

if(val==21){  //如果选择的值是 2 

                document.info_form.city.options.length = 4; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("海口市",1);
                document.info_form.city.options[2]=new Option("三亚市",2);
                document.info_form.city.options[3]=new Option("其他",3);
         
           
}
if(val==22){  //如果选择的值是 2 
                document.info_form.city.options.length = 39; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("渝中区",1);
                document.info_form.city.options[2]=new Option("大渡口区",2);
                document.info_form.city.options[3]=new Option("江北区",3);
                document.info_form.city.options[4]=new Option("沙坪坝区",4);
                document.info_form.city.options[5]=new Option("九龙坡区",5);
                document.info_form.city.options[6]=new Option("南岸区",6);
                document.info_form.city.options[7]=new Option("北碚区",7);
                document.info_form.city.options[8]=new Option("万盛区",8);
                document.info_form.city.options[9]=new Option("双桥区",9);
                document.info_form.city.options[10]=new Option("渝北区",10);
                document.info_form.city.options[11]=new Option("巴南区",11);
                document.info_form.city.options[12]=new Option("万州区",12);
                document.info_form.city.options[13]=new Option("培陵区",13);
                document.info_form.city.options[14]=new Option("黔江区",14);
                document.info_form.city.options[15]=new Option("长寿区",15);
                document.info_form.city.options[16]=new Option("合川市",16);
                document.info_form.city.options[17]=new Option("永川市",17);
                document.info_form.city.options[18]=new Option("江津市",18);
                document.info_form.city.options[19]=new Option("南川市",19);
                document.info_form.city.options[20]=new Option("綦江县",20);
                document.info_form.city.options[21]=new Option("潼南县",21);
                document.info_form.city.options[22]=new Option("铜梁县",22);
                document.info_form.city.options[23]=new Option("大足县",23);
                document.info_form.city.options[24]=new Option("璧山县",24);
                document.info_form.city.options[25]=new Option("垫江县",25);
                document.info_form.city.options[26]=new Option("武隆县",26);
                document.info_form.city.options[27]=new Option("丰都县",27);
                document.info_form.city.options[28]=new Option("城口县",28);
                document.info_form.city.options[29]=new Option("开县",29);
                document.info_form.city.options[30]=new Option("巫溪县",30);
                document.info_form.city.options[31]=new Option("奉节县",31);
                document.info_form.city.options[32]=new Option("云阳县",32);
                document.info_form.city.options[33]=new Option("忠县",33);
                document.info_form.city.options[34]=new Option("石柱土家族自治县",34);
                document.info_form.city.options[35]=new Option("彭水苗族土家族自治县",35);
                document.info_form.city.options[36]=new Option("酉阳土家族苗族自治县",36);
                document.info_form.city.options[37]=new Option("秀山土家族苗族自治县",37);
                document.info_form.city.options[38]=new Option("其他",38);

}

if(val==23){  //如果选择的值是 2 

                document.info_form.city.options.length = 22; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("成都市",1);
                document.info_form.city.options[2]=new Option("广元市",2);
                document.info_form.city.options[3]=new Option("绵阳市",3);
                document.info_form.city.options[4]=new Option("德阳市",4);
                document.info_form.city.options[5]=new Option("南充市",5);
                document.info_form.city.options[6]=new Option("广安市",6);
                document.info_form.city.options[7]=new Option("遂宁市",7);
                document.info_form.city.options[8]=new Option("内江市",8);
                document.info_form.city.options[9]=new Option("乐山市",9);
                document.info_form.city.options[10]=new Option("自贡市",10);
                document.info_form.city.options[11]=new Option("泸州市",11);
                document.info_form.city.options[12]=new Option("宜宾市",12);
                document.info_form.city.options[13]=new Option("攀枝花市",13);
                document.info_form.city.options[14]=new Option("巴中市",14);
                document.info_form.city.options[15]=new Option("资阳市",15);
             document.info_form.city.options[16]=new Option("眉山市",16);
              document.info_form.city.options[17]=new Option("雅安",17);
               document.info_form.city.options[18]=new Option("阿坝藏族羌族自治州",18);
                document.info_form.city.options[19]=new Option("甘孜藏族自治州",19);
                 document.info_form.city.options[20]=new Option("凉山彝族自治州县",20);
                  document.info_form.city.options[21]=new Option("其他",21);
            
}

if(val==24){  //如果选择的值是 2 
                document.info_form.city.options.length = 11; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("贵阳市",1);
                document.info_form.city.options[2]=new Option("六盘水市",2);
                document.info_form.city.options[3]=new Option("遵义市",3);
                document.info_form.city.options[4]=new Option("安顺市",4);
                document.info_form.city.options[5]=new Option("毕节地区",5);
                document.info_form.city.options[6]=new Option("铜仁地区",6);
                document.info_form.city.options[7]=new Option("黔东南苗族侗族自治州",7);
                document.info_form.city.options[8]=new Option("黔南布依族苗族自治州",8);
                document.info_form.city.options[9]=new Option("黔西南布依族苗族自治州",9);
                document.info_form.city.options[10]=new Option("其他",10);

}

if(val==25){  //如果选择的值是 2 

             document.info_form.city.options.length = 19; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("昆明市",1);
                document.info_form.city.options[2]=new Option("曲靖市",2);
                document.info_form.city.options[3]=new Option("玉溪市",3);
                document.info_form.city.options[4]=new Option("宝山市",4);
                document.info_form.city.options[5]=new Option("昭通市",5);
                document.info_form.city.options[6]=new Option("丽江市",6);
                document.info_form.city.options[7]=new Option("普洱市",7);
                document.info_form.city.options[8]=new Option("临沧市",8);
                document.info_form.city.options[9]=new Option("宁德市",9);
                document.info_form.city.options[10]=new Option("德宏傣族景颇族自治州",10);
                document.info_form.city.options[11]=new Option("怒江傈僳族自治州",11);
                document.info_form.city.options[12]=new Option("楚雄彝族自治州",12);
                document.info_form.city.options[13]=new Option("红河哈尼族彝族自治州",13);
                document.info_form.city.options[14]=new Option("文山壮族苗族自治州",14);
                document.info_form.city.options[15]=new Option("大理白族自治州",15);
                document.info_form.city.options[16]=new Option("迪庆藏族自治州",16);
                document.info_form.city.options[17]=new Option("西双版纳傣族自治州",17);
                document.info_form.city.options[18]=new Option("其他",18);
           
}

if(val==26){  //如果选择的值是 2 

             document.info_form.city.options.length = 9; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("拉萨市",1);
                document.info_form.city.options[2]=new Option("那曲地区",2);
                document.info_form.city.options[3]=new Option("昌都地区",3);
                document.info_form.city.options[4]=new Option("林芝地区",4);
                document.info_form.city.options[5]=new Option("山南地区",5);
                document.info_form.city.options[6]=new Option("日喀则地区",6);
                document.info_form.city.options[7]=new Option("阿里地区",7);
                document.info_form.city.options[8]=new Option("其他",8);
               
}

if(val==27){  //如果选择的值是 2 

             document.info_form.city.options.length = 11; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("西安市",1);
                document.info_form.city.options[2]=new Option("延安市",2);
                document.info_form.city.options[3]=new Option("铜川市",3);
                document.info_form.city.options[4]=new Option("渭南市",4);
                document.info_form.city.options[5]=new Option("咸阳市",5);
                document.info_form.city.options[6]=new Option("宝鸡市",6);
                document.info_form.city.options[7]=new Option("汉中市",7);
                document.info_form.city.options[8]=new Option("安康市",8);
                document.info_form.city.options[9]=new Option("商洛市",9);
                document.info_form.city.options[10]=new Option("其他",10);
         
}

if(val==28){  //如果选择的值是 2 

             document.info_form.city.options.length = 16; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("兰州市",1);
                document.info_form.city.options[2]=new Option("嘉峪关市",2);
                document.info_form.city.options[3]=new Option("金昌市",3);
                document.info_form.city.options[4]=new Option("白银市",4);
                document.info_form.city.options[5]=new Option("天水市",5);
                document.info_form.city.options[6]=new Option("武威市",6);
                document.info_form.city.options[7]=new Option("酒泉市",7);
                document.info_form.city.options[8]=new Option("张掖市",8);
                document.info_form.city.options[9]=new Option("庆阳市",9);
                document.info_form.city.options[10]=new Option("平凉市",10);
                document.info_form.city.options[11]=new Option("定西市",11);
                document.info_form.city.options[12]=new Option("陇南市",12);
                document.info_form.city.options[13]=new Option("临夏回族自治州",13);
                document.info_form.city.options[14]=new Option("甘南藏族自治州",14);
                document.info_form.city.options[15]=new Option("其他",15);
          
           
}


if(val==29){  //如果选择的值是 2 

             document.info_form.city.options.length = 10; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("西宁市",1);
                document.info_form.city.options[2]=new Option("海东地区",2);
                document.info_form.city.options[3]=new Option("海北藏族自治州",3);
                document.info_form.city.options[4]=new Option("黄南藏族自治州",4);
                document.info_form.city.options[5]=new Option("玉树藏族自治州",5);
                document.info_form.city.options[6]=new Option("海南藏族自治州",6);
                document.info_form.city.options[7]=new Option("果洛藏族自治州",7);
                document.info_form.city.options[8]=new Option("海西蒙古族藏族自治州",8);
                document.info_form.city.options[9]=new Option("其他",9);
           
}

if(val==30){  //如果选择的值是 2 

             document.info_form.city.options.length = 7; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("银川市",1);
                document.info_form.city.options[2]=new Option("石嘴山市",2);
                document.info_form.city.options[3]=new Option("吴忠市",3);
                document.info_form.city.options[4]=new Option("固原市",4);
                document.info_form.city.options[5]=new Option("中卫市",5);
                document.info_form.city.options[6]=new Option("其他",6);
                
          
           
}

 
if(val==31){  //如果选择的值是 2 

                document.info_form.city.options.length = 19; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("乌鲁木齐市",1);
                document.info_form.city.options[2]=new Option("克拉玛依市",2);
                document.info_form.city.options[3]=new Option("喀什地区",3);
                document.info_form.city.options[4]=new Option("阿克苏地区",4);
                document.info_form.city.options[5]=new Option("和田地区",5);
                document.info_form.city.options[6]=new Option("吐鲁番地区",6);
                document.info_form.city.options[7]=new Option("哈密地区",7);
                document.info_form.city.options[8]=new Option("塔城地区",8);
                document.info_form.city.options[9]=new Option("阿勒泰地区",9);
                document.info_form.city.options[10]=new Option("克孜勒苏柯尔克孜自治州",10);
                document.info_form.city.options[11]=new Option("博尔塔拉蒙古自治州",11);
                document.info_form.city.options[12]=new Option("昌吉回族自治州伊犁哈萨克自治州",12);
                document.info_form.city.options[13]=new Option("巴音郭楞蒙古自治州",13);
                document.info_form.city.options[14]=new Option("河子市",14);
                document.info_form.city.options[15]=new Option("阿拉尔市",15);
                document.info_form.city.options[16]=new Option("五家渠市",16);
                document.info_form.city.options[17]=new Option("图木舒克市",17);
                document.info_form.city.options[18]=new Option("其他",18);
          
           
}


if(val==32){  //如果选择的值是 2 

             document.info_form.city.options.length = 2; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("香港",1);
}


if(val==33){  //如果选择的值是 2 

             document.info_form.city.options.length = 2; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("澳门",1);
}


if(val==34){  //如果选择的值是 2 

             document.info_form.city.options.length = 2; //初始化select2          
                document.info_form.city.options[0]=new Option("",0);
                document.info_form.city.options[1]=new Option("台湾",1);
}



}