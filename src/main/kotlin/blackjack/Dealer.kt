package blackjack

class Dealer(val name: String = DEALER_NAME, initialCards: List<Card>) {
    private val _hand = Hand(initialCards)
    val hand: List<Card>
        get() = _hand.cards

    init {
        require(name.isNotBlank()) {
            "이름은 빈 문자열일 수 없습니다: name=$name"
        }
        require(initialCards.size == INITIAL_HAND_LENGTH) {
            "첫 패는 ${INITIAL_HAND_LENGTH}장이어야 한다: initialCards.size=${initialCards.size}"
        }
    }

    fun isInitialState(): Boolean = _hand.cards.size == 2

    fun receive(newCard: Card) {
        check(shouldDrawCard()) {
            "현재 딜러는 히트할 수 없는 상태입니다: sumOfHand=${sumOfHand()}"
        }
        _hand.add(newCard)
    }

    fun sumOfHand(): Int = _hand.sumOfHand()

    fun isBust(): Boolean = _hand.isBust()

    fun shouldDrawCard(): Boolean = sumOfHand() <= DEALER_HIT_THRESHOLD

    companion object {
        private const val INITIAL_HAND_LENGTH = 2
        private const val DEALER_NAME = "딜러"
        private const val DEALER_HIT_THRESHOLD = 16
    }
}
