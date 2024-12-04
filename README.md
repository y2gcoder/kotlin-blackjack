# kotlin-blackjack

# STEP 2: 블랙잭

## 기능 요구 사항

- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다. 
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

## 구현 기능 목록

### STEP 2 블랙잭

- [x] 각 카드의 모양은 스페이드, 클로버, 하트, 다이아몬드가 존재한다
- [x] 각 카드의 숫자는 A(ce), 2 ~ 9,  10, K(ing), Q(ueen), J(ack) 이 존재한다
- [x] 각 카드 숫자 중 10, J, Q, K는 서로 같은 숫자 10으로 계산한다
- [x] 카드 뭉치는 앞선 카드 조합 기준(4 * (1 + 9 + 3))으로 총 52장의 카드를 가지고 시작한다
- [x] 카드 뭉치는 앞선 카드 조합 기준(4 * (1 + 9 + 3))으로 총 52장의 카드를 초과하여 가지고 있을 수 없다
- [x] 카드 뭉치는 가지고 있는 카드를 한장씩 뽑을 수 있다
- [x] 카드 뭉치를 셔플하면 카드 뭉치 내부의 카드 순서가 바뀐다
- [x] 플레이어는 이름과 카드 2장을 가지고 게임을 시작한다
- [x] 플레이어의 이름은 빈 문자열일 수 없다
- [x] 플레이어는 생성 시에 카드 2장이 필수다
- [x] 플레이어는 카드 1장을 건네받아 손패에 추가할 수 있다
- [x] 플레이어는 자신이 가진 카드의 숫자 합을 알 수 있다
- [x] 손패는 카드를 추가할 수 있다
- [x] 손패는 가진 카드의 숫자 합을 구할 수 있다
- [x] 손패는 가진 카드의 숫자 합을 21에 최대한 가깝게 구할 수 있다
- [x] 플레이어는 ACE 카드를 가지고 있을 때 21에 가까운 합을 알 수 있다
- [x] ACE 카드는 1 또는 11이다 
- [x] 손패는 스스로 버스트했는지 알 수 있다
- [x] 플레이어가 버스트했는지 알 수 있다
- [x] UI 로직 추가

### STEP 3 블랙잭(딜러)

- [x] 딜러는 플레이어와 같이 카드 2장과 함께 시작한다
- [x] 딜러는 플레이어와 같이 카드를 1장 더 받을 수 있다
- [x] 딜러는 플레이어와 같이 자신의 가진 카드의 합을 알 수 있다
- [x] 딜러는 플레이어와 같이 자신이 버스트했는지 알 수 있다

- [x] 딜러는 손패 2장의 합이 16점 이하면 반드시 카드 한 장을 더 받아야 한다
- [x] 딜러는 손패 2장의 합이 17점 이상임에도 불구하고 카드를 뽑으려고 하면(히트) 예외를 던진다

- [x] 게임 심판은 딜러와 플레이어들이 모두 파산하지 않았을 때는 딜러의 손패 합 대 플레이어들 각각의 손패 합 을 따져 매긴다 
- [x] 게임 심판은 플레이어가 파산했을 때는 해당 플레이어는 패배하고 딜러가 승리한 것으로 한다.
- [x] 게임 심판은 딜러가 파산했을 때 파산한 플레이어는 패배로 판단한다
- [x] 게임 심판은 딜러가 파산했을 때에는 파산하지 않은 플레이어들 모두 승리로 한다

- [x] 게임 심판은 딜러의 승패 요약도 계산할 수 있다  

- [x] UI 로직 변경

### STEP 4 블랙잭(베팅)

- [x] 은행은 모든 참가자의 베팅 금액을 받는다
- [x] 플레이어 베팅 금액은 1원 이상이어야 한다
- [x] 은행은 각 참가자의 잔고를 알 수 있다
- [x] 핸드는 손패가 블랙잭인지 알 수 있다
- [x] 게임 심판은 딜러만 블랙잭일 때 모든 플레이어를 패배 선언한다
- [x] 게임 심판은 플레이어만 블랙잭일 때 플레이어의 블랙잭 승리 선언을 할 수 있다
- [x] 게임 심판은 PUSH(딜러와 플레이어의 손 패가 같음 혹은 둘다 블랙잭) 선언을 할 수 있다
- [ ] 은행은 게임 결과에 따라 각 참가자에게 금액을 정산한다 
  - [x] 딜러는 게임 결과로 플레이어에게 지면 플레이어가 베팅한 금액만큼 돈을 잃는다
  - [x] 플레이어는 게임 결과로 딜러보다 손패의 합이 높으면 베팅한 금액 x 2를 받는다
  - [x] 플레이어는 게임 결과로 딜러보다 손패의 합이 낮으면 베팅한 금액을 잃는다
  - [x] 딜러는 플레이어보다 손패의 합이 높으면 플레이어가 베팅한 금액을 받는다
  - [x] 플레이어가 버스트하면 베팅 금액을 잃게 된다
  - [x] 딜러는 플레이어가 버스트하면 플레이어의 베팅 금액을 받는다
  - [x] 딜러가 버스트하면 버스트하지 않은 플레이어들이 베팅한 금액의 총합을 잃는다
  - [x] 플레이어는 딜러가 버스트하면 베팅한 금액 x 2 를 받는다
  - [x] 딜러는 플레이어가 블랙잭이면 플레이어가 베팅한 금액의 1.5배를 잃는다
  - [x] 플에이어는 블랙잭이면 베팅한 금액의 x 2.5배를 받는다
  - [x] 플레이어는 딜러가 블랙잭이면 플레이어가 베팅한 금액을 잃는다
  - [x] 딜러는 블랙잭일 때 플레이어가 베팅한 금액을 받는다
  - [x] PUSH일 때는 딜러와 플레이어 모두 금액의 변동이 없다
- [x] 은행은 모든 참가자의 수익률을 보여줄 수 있다
