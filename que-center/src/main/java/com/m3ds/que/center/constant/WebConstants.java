package com.m3ds.que.center.constant;

public interface WebConstants {
    public enum subjectQueState {
        Incomplete("未完成", 0),
        InProgress("进行中", 1),
        Completed("已完成", 2);

        private final String name;
        private final int index;

        subjectQueState(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return this.name;
        }

        public int getIndex() {
            return index;
        }
    }
}
