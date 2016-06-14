package com.example.amit.crystalball;

import java.util.Random;

/**
 * Created by amit on 14/6/16.
 * Copyright 2016 Amit Sangwan

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */
public class CrystalBall {
    String answer[]={
            "It's certain",
            "It is decidedly so",
            "All signs say YES",
            "The stars are not aligned",
            "My reply is no",
            "It is doubtfull",
            "Better not tell you now",
            "Concentrate and ask again",
            "Unable to answer now"
    };
    public String getAnswer(){
        //Creating a random number
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt(answer.length);
        return answer[num];
    }
}
