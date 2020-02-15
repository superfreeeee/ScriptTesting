import React, { useState, useEffect } from 'react';
import './Clock.css';

const Clock: React.FC = props => {
  const [counter, setCounter] = useState(0);
  const [times, setTimes] = useState(0);

  console.log('run 1');
  useEffect(() => {
    document.title = `You click ${times} times.`;
  });

  const action = () => {
    setTimes(times + 1);
  };

  console.log('run 2');
  const increment = () => {
    action();
    setCounter(counter + 1);
  };

  console.log('run 3');
  const reset = () => {
    action();
    setCounter(0);
  };

  return (
    <div className='clock-border'>
      <h1>count: {counter}</h1>
      <button onClick={increment}>Click!</button>
      <button onClick={reset}>Reset</button>
    </div>
  );
};

export default Clock;
