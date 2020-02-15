import React from 'react';
import Button from '../components/Button/Button';

const ButtonTest: React.FC = () => {
  return (
    <div className='border'>
      <Button className='block' size='large'>
        Large
      </Button>
      <Button className='block'>
        Medium
      </Button>
      <Button className='block' size='small'>
        Small
      </Button>

      <Button className='block' type='primary'>
        Primary
      </Button>
      <Button className='block'>
        Default
      </Button>
      <Button className='block' type='dashed'>
        Dashed
      </Button>
      <Button className='block' type='danger'>
        Danger
      </Button>
      <Button className='block' type='link'>
        Link
      </Button>
    </div>
  );
}

export default ButtonTest