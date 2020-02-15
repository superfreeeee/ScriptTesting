import React from 'react';
import './Button.css';

const baseStyle = 'my-btn'

/**
 * type 属性
 */
type ButtonType = 'primary' | 'dashed' | 'danger' | 'link';
function addType(classNames: string[], type: ButtonType) {
  classNames.push(baseStyle + '-' + type)
}

/**
 * size 属性
 */
type ButtonSize = 'large' | 'small';
function addSize(classNames: string[], size: ButtonSize) {
  switch(size) {
    case 'large': 
      classNames.push(baseStyle + '-lg')
      break;
    case 'small': 
      classNames.push(baseStyle + '-sm')
      break;
  }
}

type ButtonShape = 'circle' | 'round';
function addShape(classNames: string[], shape: ButtonShape) {

}
/**
 * 组件属性参数
 */
interface ButtonProps {
  className?: string,
  children?: string | never[],
  type?: ButtonType,
  size?: ButtonSize,
  shape?: ButtonShape,
  onClick?: Function
}
function createClassName(props: ButtonProps): string {
  let classNames: string[] = [baseStyle]
  if(props.type)
    addType(classNames, props.type);
  if(props.size)
    addSize(classNames, props.size);
  if(props.shape)
    addShape(classNames, props.shape);
  if(props.className)
    classNames.push(props.className)
  return classNames.join(' ');
}

function resolveProps(props: ButtonProps): Object {
  return {
    className: createClassName(props),
    onClick: props.onClick
  }
}

/**
 * 组件定义
 */
const Button: React.FC<ButtonProps> = props => {
  return (
    <button {...resolveProps(props)}>
      {props.children}
    </button>
  );
}

export default Button