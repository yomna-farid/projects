'use strict';

// selecting elements
const elPlayer0 = document.querySelector('.player--0');
const elPlayer1 = document.querySelector('.player--1');
const elScore0 = document.getElementById('score--0');
const elScore1 = document.getElementById('score--1');
const elCurrent0 = document.getElementById('current--0');
const elCurrent1 = document.getElementById('current--1');
const elDice0 = document.querySelector('.dice0');
const elDice1 = document.querySelector('.dice1');

// initializing variables
let scores, currentScore, activePlayer, playing;

// starting conditions for game
const newGame = function () {
  //initializing score, active player, and game state
  scores = [0, 0];
  currentScore = 0;
  activePlayer = 0;
  playing = true;

  elScore0.textContent = 0;
  elScore1.textContent = 0;
  elCurrent0.textContent = 0;
  elCurrent1.textContent = 0;

  elDice0.classList.add('hidden');
  elDice1.classList.add('hidden');
  elPlayer0.classList.remove('player--winner');
  elPlayer1.classList.remove('player--winner');
  elPlayer0.classList.add('player--active');
  elPlayer1.classList.remove('player--active');
};

// initializing the game
newGame();

// function to switch players
const switchPlayer = function () {
  document.getElementById(`current--${activePlayer}`).textContent = 0;
  activePlayer = activePlayer === 0 ? 1 : 0;
  currentScore = 0;
  elPlayer0.classList.toggle('player--active');
  elPlayer1.classList.toggle('player--active');
};

// event listener for roll dice button
document.querySelector('.btn--roll').addEventListener('click', function () {
  if (playing) {
    // generating a random dice roll and displaying them
    const dice0 = Math.trunc(Math.random() * 6) + 1;
    const dice1 = Math.trunc(Math.random() * 6) + 1;
    elDice0.classList.remove('hidden');
    elDice0.src = `dice-${dice0}.jpg`;
    elDice1.classList.remove('hidden');
    elDice1.src = `dice-${dice1}.jpg`;

    // game logic based on the dice rolls
    if ((dice0 !== 1) & (dice1 !== 1)) {
      // add dice to current score
      currentScore += dice0 + dice1;
      document.getElementById(`current--${activePlayer}`).textContent =
        currentScore;
    } else if ((dice0 === 1) & (dice1 === 1)) {
      scores[activePlayer] = 0;
      document.getElementById(`score--${activePlayer}`).textContent = scores[
        activePlayer
      ] = 0;
      switchPlayer();
    } else {
      switchPlayer();
    }
  }
});

// event listener for hold button
document.querySelector('.btn--hold').addEventListener('click', function () {
  // add current score to active player's total score
  if (playing) {
    scores[activePlayer] += currentScore;
    document.getElementById(`score--${activePlayer}`).textContent =
      scores[activePlayer];
    // checking if there's a winner if the players score is >= 100
    if (scores[activePlayer] >= 100) {
      // finish Game
      playing = false;
      elDice0.classList.add('hidden');
      elDice1.classList.add('hidden');
      document
        .querySelector(`.player--${activePlayer}`)
        .classList.add('player--winner');
      document
        .querySelector(`.player--${activePlayer}`)
        .classList.remove('player--active');
    } else {
      switchPlayer();
    }
  }
});

// event listner for starting new game button
document.querySelector('.btn--new').addEventListener('click', newGame);
