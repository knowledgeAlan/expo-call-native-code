import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View ,Button,Alert,NativeModules} from 'react-native';
const { CalendarModule,IminPrintModule } = NativeModules;


export default function App() {

  const buttonPress = () => {
    console.log("button===press");
    CalendarModule.createCalendarEvent('testName', 'testLocation');
  }

  const buttonPrint = () => {
    console.log("button===print");
    console.log("Printing......");
     let type = "test" + "\n";
    

    IminPrintModule.iminPrint(
      type
    );

  }


   

  const testCallBack = () => {
    console.log("testCallBack====");
    CalendarModule.testCallBack("fdf","test",(result) => {
      console.log("CalendarModule.test================================",result);
    })
  }

  const iminPrintStatus = () => {
    console.log("iminPrintStatus====");
    IminPrintModule.iminPrintStatus((resultSatus) => {
      console.log("resultSatus======",resultSatus)
    })

  }
  return (
    <View style={styles.container}>
      <Text>react native call native method</Text>
      <Button
        title="Press me"
        onPress={() => buttonPress()}
      />

    <Button
        title="print"
        onPress={() => buttonPrint()}
      />

    


    <Button
        title="testCallBack"
        onPress={() => testCallBack()}
      />

      <Button
        title="iminPrintStatus"
        onPress={() => iminPrintStatus()}
      />    
      <StatusBar style="auto" />
    </View>

    
    
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
