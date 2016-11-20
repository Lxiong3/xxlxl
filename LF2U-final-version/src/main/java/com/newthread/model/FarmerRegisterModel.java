package com.newthread.model;

import java.util.List;



public class FarmerRegisterModel {
    /**
     * farm_info : {"name":"SafeHouse Farm Alpacas","address":"25550 W Cuba Rd, Barrington, IL 60010","phone":"847-651-2140","web":"http://www.openherd.com/"}
     * personal_info : {"name":"John Smith","email":"john.smith@example.com","phone":"123-456-7890"}
     * delivers_to : ["60010","60011","60067"]
     */

    private FarmInfoBean farm_info;
    private PersonalInfoBean personal_info;
    private List<String> delivers_to;

    public FarmInfoBean getFarm_info() {
        return farm_info;
    }

    public void setFarm_info(FarmInfoBean farm_info) {
        this.farm_info = farm_info;
    }

    public PersonalInfoBean getPersonal_info() {
        return personal_info;
    }

    public void setPersonal_info(PersonalInfoBean personal_info) {
        this.personal_info = personal_info;
    }

    public List<String> getDelivers_to() {
        return delivers_to;
    }

    public void setDelivers_to(List<String> delivers_to) {
        this.delivers_to = delivers_to;
    }

    public static class FarmInfoBean {
        /**
         * name : SafeHouse Farm Alpacas
         * address : 25550 W Cuba Rd, Barrington, IL 60010
         * phone : 847-651-2140
         * web : http://www.openherd.com/
         */

        private String name;
        private String address;
        private String phone;
        private String web;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getWeb() {
            return web;
        }

        public void setWeb(String web) {
            this.web = web;
        }
    }

    public static class PersonalInfoBean {
        /**
         * name : John Smith
         * email : john.smith@example.com
         * phone : 123-456-7890
         */

        private String name;
        private String email;
        private String phone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
