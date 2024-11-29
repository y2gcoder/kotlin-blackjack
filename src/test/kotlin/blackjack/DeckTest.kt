package blackjack

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DeckTest : StringSpec({
    "카드 뭉치는 가지고 있는 카드를 한장씩 뽑을 수 있다" {
        val cards = listOf(Card(CardNumber.ACE, Suit.SPADES), Card(CardNumber.TWO, Suit.SPADES))
        val sut = Deck(cards.toMutableList())

        val firstCard = sut.draw()
        val secondCard = sut.draw()

        firstCard shouldBe cards[0]
        secondCard shouldBe cards[1]
    }
})
