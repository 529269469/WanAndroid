package com.example.wanandroid.bean;

import java.util.List;

/**
 * @author :created by ${ WYW }
 * 时间：2019/3/22 09
 */
public class UserBean {

    /**
     * code : 0
     * data : [{"id":"1","userName":"admin","password":"123456","name":"管理员","code":"13811244057","headImage":"20190217/12435242L-0.jpg","specialty":"软件工程","profession":"程序员1众","sortTimes":1544855499910,"authority":31},{"id":"1jrqchiaa6hekpvq6q8hbaa65u","userName":"6","password":"000000","name":"6","code":"6","headImage":"20190120/Penguins.jpg","specialty":"6","profession":"6","sortTimes":1547981208847,"authority":6},{"id":"6ekppuq1qehbnr2jrmbmupe7db","userName":"22","password":"000000","name":"22","code":"22","headImage":"20190120/Hydrangeas.jpg","specialty":"22","profession":"22","sortTimes":1547979837958,"authority":27},{"id":"7q2bfnuqlei17rsa23naiklia4","userName":"qq","password":"000000","name":"qqqq","code":"qqq","headImage":"","specialty":"qq","profession":"qq","sortTimes":1547982124329,"authority":4},{"id":"o61ktkp7rchotp4jsjkbgd1jer","userName":"4","password":"000000","name":"4","code":"4","headImage":"20190120/微信图片_20181218173421.png","specialty":"4","profession":"4","sortTimes":1547980017383,"authority":9},{"id":"ovoo4f00u2guhobgmsas2bfvfb","userName":"7","password":"000000","name":"7","code":"7","headImage":"20190120/Hydrangeas.jpg","specialty":"7","profession":"7","sortTimes":1547981236830,"authority":6},{"id":"sc539gog40g7eoco51vsihg9df","userName":"2","password":"000000","name":"2","code":"2","headImage":"","specialty":"2","profession":"2","sortTimes":1547980514987,"authority":6},{"id":"utelu9t134jdlr7ug9n6ed5bft","userName":"5","password":"000000","name":"5","code":"5","headImage":"20190120/Desert2.jpg","specialty":"5","profession":"5","sortTimes":1547981194280,"authority":2},{"id":"vtte7amvbmi12q5m16de25fsv1","userName":"1","password":"000000","name":"1","code":"1","headImage":"20190127/Tulips.jpg","specialty":"1","profession":"1","sortTimes":1547980389499,"authority":10}]
     * count : 9
     */

    private int code;
    private int count;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * userName : admin
         * password : 123456
         * name : 管理员
         * code : 13811244057
         * headImage : 20190217/12435242L-0.jpg
         * specialty : 软件工程
         * profession : 程序员1众
         * sortTimes : 1544855499910
         * authority : 31
         */

        private String id;
        private String userName;
        private String password;
        private String name;
        private String code;
        private String headImage;
        private String specialty;
        private String profession;
        private long sortTimes;
        private int authority;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getHeadImage() {
            return headImage;
        }

        public void setHeadImage(String headImage) {
            this.headImage = headImage;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public long getSortTimes() {
            return sortTimes;
        }

        public void setSortTimes(long sortTimes) {
            this.sortTimes = sortTimes;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }
    }
}
