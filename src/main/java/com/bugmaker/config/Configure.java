package com.bugmaker.config;

public final class Configure {
    /**
     * @brief orders_status
     * @note 默认为WAIT
     */
    public enum orders_status{
        WAIT("wait"),
        DOING("doing"),
        FINISH("finish"),
        CANCEL("cancel");

        private String status;

        private orders_status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }



}
