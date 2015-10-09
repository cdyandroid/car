package com.car.entity;


import java.util.List;

/**
 * Created by Administrator on 2015-10-01.
 */
public class NewsItem {


    /**
     * list : [{"id":1,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":1,"image_list":null,"type":3},{"id":2,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":2,"image_list":null,"type":3},{"id":1,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":4,"image_list":null,"type":3},{"id":3,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":3,"image_list":null,"type":3},{"id":4,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":4,"image_list":null,"type":3},{"id":5,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":5,"image_list":null,"type":3},{"id":6,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":6,"image_list":null,"type":3},{"id":7,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":7,"image_list":null,"type":3},{"id":8,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":8,"image_list":null,"type":3},{"id":9,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":9,"image_list":null,"type":3},{"id":10,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":10,"image_list":null,"type":3},{"id":11,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":11,"image_list":null,"type":3},{"id":12,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":12,"image_list":null,"type":3},{"id":13,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":13,"image_list":null,"type":3},{"id":14,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":14,"image_list":null,"type":3},{"id":15,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":15,"image_list":null,"type":3},{"id":16,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":16,"image_list":null,"type":3},{"id":17,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":17,"image_list":null,"type":3},{"id":18,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":18,"image_list":null,"type":3},{"id":19,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":19,"image_list":null,"type":3},{"id":20,"cover_image":"car.jpg","title":"比亚迪6月6日发布最新款车型","nid":20,"image_list":null,"type":3}]
     */

    private List<ListEntity> list;

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class ListEntity {
        /**
         * id : 1
         * cover_image : car.jpg
         * title : 比亚迪6月6日发布最新款车型
         * nid : 1
         * image_list : null
         * type : 3
         */

        private int id;
        private String cover_image;
        private String title;
        private int nid;
        private Object image_list;
        private int type;

        public void setId(int id) {
            this.id = id;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setNid(int nid) {
            this.nid = nid;
        }

        public void setImage_list(Object image_list) {
            this.image_list = image_list;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public String getCover_image() {
            return cover_image;
        }

        public String getTitle() {
            return title;
        }

        public int getNid() {
            return nid;
        }

        public Object getImage_list() {
            return image_list;
        }

        public int getType() {
            return type;
        }
    }
}
