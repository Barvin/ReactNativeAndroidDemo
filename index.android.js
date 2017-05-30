'use strict';

import React, {Component} from 'react';
import {
  AppRegistry,
  Platform,
  StyleSheet,
  TextInput,
  Text,
  TouchableOpacity,
  TouchableHighlight,
  View
} from 'react-native';

import ToastAndroid from './ToastAndroid'

class HelloWorld extends React.Component {
  constructor(props){
    super(props)
    this.state = {msg: this.props.defaultMsg}
  }

  showToast(type) {
    if (type.includes('Long')) {
      ToastAndroid.show(this.state.msg, ToastAndroid.LONG)
    }
    else{
      ToastAndroid.show(this.state.msg, ToastAndroid.SHORT)      
    }
  }

  renderButtons(type) {
    let btnClr = ''
    if (type.includes('Long')) {btnClr = 'orange'}
    else if (type.includes('Short')) {btnClr = 'yellow'}

    return (
      <TouchableHighlight key={type} onPress={() => this.showToast(type)} activeOpacity={0.2}>
        <View style={[styles.prioBtnSize, styles.buttonView, {backgroundColor: btnClr}]}>
          <Text style={styles.buttonText}>{type}</Text>
        </View>
      </TouchableHighlight>
    )
  }

  render() {
    let buttons = ["Long Toast", "Short Toast"]

    let addCourse = () => ToastAndroid.setCourse(this.state.msg)

    return (
      <View style={styles.device}>
        <Text style={styles.title}>Toast API</Text>

        <Text style={styles.h3}>Enter Toast message</Text>
				<TextInput
					style={styles.searchBox}
					onChangeText={(text) => {
						this.setState({msg: text})
					}}
          value={this.state.msg}
				/>

        <View style={styles.buttons}>
          {buttons.map((type) => this.renderButtons(type))}
        </View>

        <Text>Props received from native: {this.props.defaultMsg}</Text>

        <TouchableHighlight onPress={addCourse} activeOpacity={0.2}>
            <Text style={[styles.buttonText, {color: 'white'}]}>ADD Course</Text>
        </TouchableHighlight>

			</View>
    )
  }
}
var styles = StyleSheet.create({
  device: {
    paddingTop: Platform.OS === 'ios' ? 64 : 54,
    flex: 1
  },
  buttons: {
    flexDirection: "row",
    justifyContent: 'center'
  },
  prioBtnSize: {
    width: 200, 
    height: 55,
  },
  buttonView: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  searchBox: {
    fontSize: 20,        
    height: 50,
    borderColor: 'black',
    borderWidth: 1,
    margin: 1,
    paddingLeft: 10,
    backgroundColor: '#F6F6F6'
  },
  buttonText: {
    fontSize: 22,
    fontWeight: 'bold'
  },
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  h3: {
    fontWeight: 'bold'
  },
  title: {
    fontSize: 30,
    textAlign: 'center',
    margin: 10,
    fontWeight: 'bold'
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);