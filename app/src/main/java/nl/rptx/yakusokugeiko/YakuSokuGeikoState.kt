package nl.rptx.yakusokugeiko

data class YakuSokuGeikoState(val pairs: List<Assignment>) {
    private var currentElement: Int = 0

    fun getNext(): Assignment {
        var element = pairs.elementAtOrNull(currentElement++)
        if(element == null) {
            currentElement = 0
            return getNext()
        }

        return element
    }
}