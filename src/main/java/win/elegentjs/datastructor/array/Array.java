package win.elegentjs.datastructor.array;

/**
 *
 * 使用数组实现线性表数据结构（线性存储）
 *
 * 完成 增加，删除，查找，遍历元素的方法
 *
 */
public class Array {

    private int[] array;

    private int elements;

    private int length;

    /**
     * 默认构造函数，初始化数组的默认长度是50。
     */
    public Array() {
        elements = 0;
        length = 50;
        array = new int[length];
    }

    /**
     * 指定数组长度，并初始化指定长度的数组
     * @param length
     */
    public Array(int length) {
        elements = 0;
        this.length = length;
        array = new int[length];
    }

    /**
     *
     * 返回当前线性表实际存储元素的个数
     * @return
     */
    public int size() {
        return elements;
    }


    /**
     * 往线性表新增元素，增加到线性表末尾
     * @param value
     */
    public void add(int value) {
        if (size() == length) {
            throw new IllegalStateException("线性表已满，无法再新增元素");
        }

        array[elements ++] = value;

    }

    /**
     * 获取指定索引位置的元素
     * @param searchValue
     * @return
     */
    public int get(int searchValue) {
        if (searchValue < 0 || searchValue >= elements) {
            throw new IllegalStateException("searchValue: " + searchValue + " 非法，范围必须是：[" + "0~" + (elements - 1) +  "]");
        }

        return array[searchValue];

    }

    /**
     * 查找指定元素的下标（不存在指定的元素时，下标为-1）
     * @param searchValue
     * @return
     */
    public int find(int searchValue) {
        int target = -1;
        for (int index = 0; index < elements; index ++) {
            if (array[index] == searchValue) {
                target = index;

                break;
            }
        }

        return target;

    }


    /**
     *
     * 删除线性表中指定元素
     * @param value
     * @return
     */
    public boolean del(int value) {
        int index = find(value);

        if (index == -1) {
            return false;
        }

        // 恰好删除的是最后一个元素，直接将当前elements减1即可
        if (index == elements - 1) {
            elements --;

            return true;

        }


        //需要删除的元素位于线性表中间或第一元素，需要执行移位
        for(int i = index; i < elements - 1; i ++) {
            array[i] = array[i + 1];
        }

        elements --;

        return true;
    }

    /**
     * 修改指定元素
     * @param old
     * @param newVal
     * @return
     */
    public boolean modify(int old, int newVal) {
        int index = find(old);

        if (index == -1) {return false;}

        array[index] = newVal;

        return true;

    }

    /**
     * 迭代打印线性表
     */
    public void display() {
        for(int index = 0; index < elements; index ++) {
            System.out.println("array[" + index + "] = " + array[index]);
        }

        System.out.println();
        System.out.println();
    }



}
