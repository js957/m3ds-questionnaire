package com.m3ds.que.center.constant;

public interface WebConstants {
    public enum subjectQueState {
        Incomplete("未完成", 0),
        InProgress("进行中", 1),
        Completed_but_not_submitted("已完成未提交", 2),
        Completed_and_submitted("已完成已提交", 3);

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
