package aquarium

class MyIntList {
    fun get(pos: Int): Int {
        return 0
    }

    fun addItem(item: Int) {}
}

class MyShortList {
    fun get(pos: Short): Short {
        return 0
    }

    fun addItem(item: Short) {}
}

class MyList<T> {
    fun get(pos: Int): Short {
        return 0
    }

    fun addItem(item: Short) {}
}

fun workWithMyLIst() {
    val intList: MyList<String>
    val fishList: MyList<Fish>
}