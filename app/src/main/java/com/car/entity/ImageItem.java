package com.car.entity;

import java.util.List;

/**
 * Created by Administrator on 2015-10-03.
 */
public class ImageItem {

    /**
     * list : [{"id":1,"image":"http://pic2.nipic.com/20090417/1263764_020611788_2.jpg"},{"id":2,"image":"http://pic79.nipic.com/file/20150925/21640853_111519079000_2.jpg"},{"id":3,"image":"http://pic79.nipic.com/file/20150930/4499633_002336988000_2.jpg"}]
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
         * image : http://pic2.nipic.com/20090417/1263764_020611788_2.jpg
         */

        private int id;
        private String image;

        public void setId(int id) {
            this.id = id;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getId() {
            return id;
        }

        public String getImage() {
            return image;
        }
    }
}
