import React, { Component } from 'react';
import { Layout } from 'antd'
import './MyLayout.css'
import Editor from '../editor/Editor'

const { Header, Sider, Content } = Layout

class MyLayout extends Component {

  constructor(props) {
    super(props)
    this.state = {
      time: 0
    }

    // this.adding = this.adding.bind(this)
  }

  hi() {
    console.log('hi')
  }

  adding = () => {
    const time = this.state.time + 1
    this.setState({
      time: time
    })
  }

  render() {
    const time = this.state.time
    return (
      <Layout className="layout">
        <Header>
          header
        </Header>
        <Layout>
          <Sider>
            sider
          </Sider>
          <Content>
            <Editor></Editor>
          </Content>
        </Layout>
      </Layout>
    )
  }

}

export default MyLayout