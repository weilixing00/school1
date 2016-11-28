package com.example.administrator.school.net.service;

import java.util.List;

/**
 * Created by server on 2016/7/8.
 */

public class TestResponse {

    /**
     * count : 8
     * code : 0
     * viewList : [{"area_id":"110007","hall":4,"imagePath":"http://static.hpbanking.com/xg/uploads/house/houseResource/big/a1eb8e3e4d5faee3c8cceddc6c98c3bb.jpg","lng":null,"towards":12,"total_floor":1,"plotName":"萧山区义桥镇","title":"张晨的豪宅","toilet":5,"pay_type":1,"publish_type":2,"lat":null,"balcony":4,"refresh_time":"99天前更新","decoration":5,"status":2,"kitchen":4,"rental":3200000,"size":240,"rent_type":1,"houses_id":21,"floor":1,"address":"浙江省杭州市萧山区东方路88号","real_name":"张晨","room":8},{"area_id":"110004","hall":3,"imagePath":"http://static.hpbanking.com/xg/uploads/house/houseResource/big/bf3e692e0d4044b731e6948591c7bd13.jpg","lng":"120.08074277938","towards":2,"total_floor":7,"plotName":"西城博司","title":"grapegrapegrape","toilet":3,"pay_type":2,"publish_type":2,"lat":"30.321421143705","balcony":3,"refresh_time":"56天前更新","decoration":1,"status":2,"kitchen":3,"rental":150000,"size":100,"rent_type":1,"houses_id":46,"floor":5,"address":"事实上","real_name":"花花","room":2},{"area_id":"110005","hall":2,"imagePath":"http://static.hpbanking.com/xg/uploads/house/houseResource/big/bf3e692e0d4044b731e6948591c7bd13.jpg","lng":"120.18844240203","towards":1,"total_floor":22,"plotName":"中兴和园","title":"cookys girl","toilet":2,"pay_type":6,"publish_type":2,"lat":"30.163662492322","balcony":1,"refresh_time":"56天前更新","decoration":3,"status":2,"kitchen":0,"rental":15000000,"size":300,"rent_type":3,"houses_id":47,"floor":17,"address":"时代大道以西，火炬大道以东","real_name":"科迪","room":5},{"area_id":"110004","hall":5,"imagePath":"http://static.hpbanking.com/xg/uploads/house/houseResource/big/8497a64e6aa1923e9a7524126786048f.jpg","lng":"120.13820345547","towards":2,"total_floor":1,"plotName":"九莲新村","title":"ysy01","toilet":5,"pay_type":6,"publish_type":2,"lat":"30.284558682443","balcony":5,"refresh_time":"52天前更新","decoration":2,"status":2,"kitchen":5,"rental":170000,"size":111,"rent_type":2,"houses_id":48,"floor":1,"address":"浙江省杭州市西湖区九莲新村","real_name":"小王","room":5},{"area_id":"110004","hall":2,"imagePath":"http://static.hpbanking.com/xg/uploads/house/houseResource/big/95c355c3f9cd9b1871073514f78823a9.jpg","lng":"120.15046114317","towards":3,"total_floor":2,"plotName":"天目山路101号","title":"出租标题就是我","toilet":2,"pay_type":2,"publish_type":2,"lat":"30.277516835996","balcony":2,"refresh_time":"51天前更新","decoration":2,"status":2,"kitchen":2,"rental":150000,"size":100,"rent_type":1,"houses_id":51,"floor":5,"address":"天目山路101吗","real_name":"grape","room":3},{"area_id":"110004","hall":1,"imagePath":"http://static.hpbanking.com/xg/uploads/house/houseResource/big/95c355c3f9cd9b1871073514f78823a9.jpg","lng":"120.154258312","towards":2,"total_floor":6,"plotName":"天目山路116号","title":"开心，又要被出租了","toilet":1,"pay_type":2,"publish_type":2,"lat":"30.279967192742","balcony":1,"refresh_time":"51天前更新","decoration":1,"status":2,"kitchen":1,"rental":150000,"size":100,"rent_type":1,"houses_id":54,"floor":7,"address":"天目山路","real_name":"grape","room":3},{"area_id":"110005","hall":1,"imagePath":"http://static.hpbanking.com/xg/uploads/house/houseResource/big/40f95209db5cdef5d81a74aba92dfc83.jpg","lng":"120.22696707464","towards":7,"total_floor":9,"plotName":"滨安小区","title":"5.27测试","toilet":1,"pay_type":4,"publish_type":2,"lat":"30.191707490958","balcony":1,"refresh_time":"41天前更新","decoration":3,"status":2,"kitchen":1,"rental":90000,"size":89,"rent_type":1,"houses_id":56,"floor":5,"address":"西溪","real_name":"张胜","room":2},{"area_id":"110005","hall":1,"imagePath":"http://static.hpbanking.com/xg/uploads/house/houseResource/big/0797cb1ce1286a7f0261a8039e7ff5f0.jpg","lng":"120.2154870724727","towards":11,"total_floor":20,"plotName":"滨康二苑","title":"推荐房源","toilet":2,"pay_type":2,"publish_type":2,"lat":"30.183771430360004","balcony":1,"refresh_time":"35天前更新","decoration":3,"status":2,"kitchen":1,"rental":300000,"size":100,"rent_type":1,"houses_id":57,"floor":16,"address":"18幢1单元1602","real_name":"XX客服","room":4}]
     */

    public int count;
    public int code;
    /**
     * area_id : 110007
     * hall : 4
     * imagePath : http://static.hpbanking.com/xg/uploads/house/houseResource/big/a1eb8e3e4d5faee3c8cceddc6c98c3bb.jpg
     * lng : null
     * towards : 12
     * total_floor : 1
     * plotName : 萧山区义桥镇
     * title : 张晨的豪宅
     * toilet : 5
     * pay_type : 1
     * publish_type : 2
     * lat : null
     * balcony : 4
     * refresh_time : 99天前更新
     * decoration : 5
     * status : 2
     * kitchen : 4
     * rental : 3200000
     * size : 240
     * rent_type : 1
     * houses_id : 21
     * floor : 1
     * address : 浙江省杭州市萧山区东方路88号
     * real_name : 张晨
     * room : 8
     */

    public List<ViewListBean> viewList;

    public static class ViewListBean {
        public String area_id;
        public int hall;
        public String imagePath;
        public Object lng;
        public int towards;
        public int total_floor;
        public String plotName;
        public String title;
        public int toilet;
        public int pay_type;
        public int publish_type;
        public Object lat;
        public int balcony;
        public String refresh_time;
        public int decoration;
        public int status;
        public int kitchen;
        public int rental;
        public int size;
        public int rent_type;
        public int houses_id;
        public int floor;
        public String address;
        public String real_name;
        public int room;
    }
}
