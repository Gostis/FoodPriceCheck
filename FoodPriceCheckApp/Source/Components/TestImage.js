import React, { Component } from 'react';
import { AppRegistry, View, Image } from 'react-native';

export default class DisplayAnImage extends Component {
    render() {
        return (
            <View>
                <Image
                    style={{width: 100%, height: 100%}}
                    source={require('./Images/Randy_Marsh.png')}
                />
            </View>
        );
    }
}