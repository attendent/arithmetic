package com.qg.enroll.enums;

public enum ProcessEnum {

    BEGIN(0),

    WRITTEN_TEST_CROSS(1),

    WRITTEN_TEST_FAIL(-1),

    FIRST_TEST_CROSS(2),

    FIRST_TEST_FAIL(-2),

    SECOND_TEST_CROSS(3),

    SECOND_TEST_FAIL(-3),

    ALL_CROSS(4);

    private int position;

    ProcessEnum(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
