package blackjack

import blackjack.Outcome.DRAW
import blackjack.Outcome.LOSS
import blackjack.Outcome.WIN
import blackjack.Suit.CLUBS
import blackjack.Suit.DIAMONDS
import blackjack.Suit.HEARTS
import blackjack.Suit.SPADES
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder

class GameJudgeTest : StringSpec({
    "게임 심판은 딜러보다 플레이어의 손패 합이 높을 때 각 플레이어들이 딜러에게 이겼다고 판단한다" {
        val initial18Cards = listOf(Card(Number(9), SPADES), Card(Number(9), DIAMONDS))
        val dealer =
            Dealer(initial18Cards)

        val initial20Cards = listOf(Card(Number(10), HEARTS), Card(CardNumber.Jack, HEARTS))
        val player1 = Player("pobi", initial20Cards)

        val initial19Cards = listOf(Card(Number(10), CLUBS), Card(Number(9), CLUBS))
        val player2 = Player("jason", initial19Cards)

        val sut = GameJudge()

        val results = sut.judge(dealer, listOf(player1, player2))

        results shouldContainExactlyInAnyOrder listOf(GameResult(player1, WIN), GameResult(player2, WIN))
    }

    "게임 심판은 딜러보다 플레이어 손패 합이 낮을 때 각 플레이들이 딜러에게 졌다고 판단한다" {
        val initial19Cards = listOf(Card(Number(10), CLUBS), Card(Number(9), CLUBS))
        val dealer = Dealer(initial19Cards)

        val initial18Cards = listOf(Card(Number(9), SPADES), Card(Number(9), DIAMONDS))
        val player = Player("y2gcoder", initial18Cards)

        val sut = GameJudge()

        val results = sut.judge(dealer, listOf(player))

        results shouldContainExactlyInAnyOrder listOf(GameResult(player, LOSS))
    }

    "게임 심판은 딜러와 플레이어의 손패 합이 같으면 각 플레이어들이 딜러와 비겼다고 판단한다" {
        val initial19Cards = listOf(Card(Number(10), CLUBS), Card(Number(9), CLUBS))
        val dealer = Dealer(initial19Cards)

        val initial18Cards = listOf(Card(Number(9), SPADES), Card(Number(9), DIAMONDS))
        val player = Player("y2gcoder", initial18Cards)
        player.receive(Card(CardNumber.Ace, SPADES))

        val sut = GameJudge()

        val results = sut.judge(dealer, listOf(player))

        results shouldContainExactlyInAnyOrder listOf(GameResult(player, DRAW))
    }
})