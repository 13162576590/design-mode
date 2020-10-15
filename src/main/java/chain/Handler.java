package chain;

/**
 * 项目名称：design.mode
 * 类 名 称：Handler
 * 类 描 述：TODO
 * 创建时间：2020/10/12 9:13 下午
 * 创 建 人：chenyouhong
 */
public abstract class Handler<T> {

    protected Handler<T> next;

//    private void next(Handler<T> next) {
//        this.next = next;
//    }

    protected abstract void doHandler(Member member);

    public static class Builder<T> {

        private Handler<T> head;

        private Handler<T> tail;

        public Builder<T> addHandler(Handler handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
//            this.tail.next(handler);
            this.tail.next = handler;
            this.tail = handler;
            return this;
        }

        public Handler<T> build() {
            return this.head;
        }

    }



}
