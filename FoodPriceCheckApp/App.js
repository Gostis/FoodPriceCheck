import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import DisplayAnImage from './Source/Components/TestImage';

export default class App extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text>Cool React Native application</Text>
          <DisplayAnImage/>
      </View>

    );
  }
}



const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
