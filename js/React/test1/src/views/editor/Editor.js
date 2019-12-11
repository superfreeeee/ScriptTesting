import React, { Component } from 'react';
import './Editor.css'

class Editor extends Component {
  render() {
    return (
      <textarea name="file" rows="20" cols="30" >
        dtmf / script_dtmf_0.pcm
        dtmf / script_dtmf_1.pcm
        dtmf / script_dtmf_2.pcm
        dtmf / script_dtmf_3.pcm
        dtmf / script_dtmf_4.pcm
        dtmf / script_dtmf_5.pcm
        dtmf / script_dtmf_6.pcm
        dtmf / script_dtmf_7.pcm
        dtmf / script_dtmf_8.pcm
        dtmf / script_dtmf_9.pcm
        dtmf / script_dtmf_x.pcm
        dtmf / script_dtmf_h.pcm
        dtmf / script_dtmf_,.pcm
        dtmf / script_dtmg_gg.pcm
      </textarea >
    );
  }
}

export default Editor;