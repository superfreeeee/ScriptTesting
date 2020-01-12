import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';

// class Square extends React.Component {
//   constructor(props){
//     super(props);
//     this.state = {
//       value: null,
//     }
    
//   }
//   render() {
//     return (
//       <button className="square"
//         onClick={() => this.props.onClick()} 
//       >
//         {this.props.value}
//       </button>
//     );
//   }
// }

function Square(props) {
  return (
    <button className="square" onClick={props.onClick}>
      {props.value}
    </button>
  );
}

class Board extends React.Component {
  // constructor(props){
  //   super(props);
  //   this.state = {
  //     squares: Array(9).fill(null),
  //     xIsNext: true
  //   }
  // }
  renderSquare(i) {
    return (
      <Square 
        value={this.props.squares[i]}
        onClick = {() => {this.props.onClick(i)}}
      />
    );
  }
  render() {
    return (
      <div>
        <div className="board-row">
          {this.renderSquare(0)}
          {this.renderSquare(1)}
          {this.renderSquare(2)}
        </div>
        <div className="board-row">
          {this.renderSquare(3)}
          {this.renderSquare(4)}
          {this.renderSquare(5)}
        </div>
        <div className="board-row">
          {this.renderSquare(6)}
          {this.renderSquare(7)}
          {this.renderSquare(8)}
        </div>
      </div>
    );
  }
}

class Game extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      history: [{
        squares: Array(9).fill(null),
      }],
      stepNumber: 0,
      xIsNext: true,
    }
    // console.log(this.state);
  }
  handleClick(i){
    const history = this.state.history.slice(0, this.state.stepNumber+1);
    const current = history[history.length - 1];
    const squares = current.squares.slice();
    if(calculateWinner(squares) || squares[i])
      return;
    squares[i] = this.state.xIsNext ? 'X' : 'O';
    // 更新組件，同時改變下一位玩家
    this.setState({
      history: history.concat([{
        squares:squares,
      }]),
      stepNumber: history.length,
      xIsNext: !this.state.xIsNext,
    });
    // console.log(this.state.history);
  }
  jumpTo(step){
    this.setState({
      history: this.state.history.slice(0, step+1),
      stepNumber: step,
      xIsNext: step % 2 === 0 ,
    });
  }
  render() {
    const history = this.state.history;
    const current = history[this.state.stepNumber];
    const winner = calculateWinner(current.squares);

    const moves = history.map((step, move) => {
      const desc = move ?
        `Go to move #${move}`:
        `Go to game start`;
      // console.log(step, move);
      const player = move % 2 === 0 ? 'X' : 'O';
      return (
        <li key={move}>
          <button onClick={() => this.jumpTo(move)}>{desc}</button>
          {` with ${player} at `}
        </li>
      );
    });

    let status = winner ?
      `Winner: ${winner}` :
      `Next player: ${this.state.xIsNext ? 'X' : 'O'}`;
    return (
      <div className="game">
        <div className="game-board">
          <Board 
            squares={current.squares}
            onClick={(i) => {this.handleClick(i)}}
          />
        </div>
        <div className="game-info">
          <div>{status}</div>
          <ol>{moves}</ol>
        </div>
      </div>
    );
  }
}
function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for(let [a, b, c] of lines){
    if(squares[a] === squares[b] && squares[a] === squares[c])
      return squares[a];
  }
  return null;
}
// ========================================

ReactDOM.render(
  <Game />,
  document.getElementById('root')
);



// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

