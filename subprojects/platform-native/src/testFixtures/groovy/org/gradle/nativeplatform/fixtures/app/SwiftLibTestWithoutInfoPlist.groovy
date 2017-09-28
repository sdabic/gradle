/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.nativeplatform.fixtures.app

import org.gradle.integtests.fixtures.SourceFile

class SwiftLibTestWithoutInfoPlist extends XCTestSourceElement {
    final XCTestSourceFileElement sumTest
    final XCTestSourceFileElement greeterTest
    final XCTestSourceFileElement multiplyTest

    SwiftLibTestWithoutInfoPlist(GreeterElement greeter, SumElement sum, MultiplyElement multiply) {
        sumTest = new SwiftSumTest("GreeterTest", sum).withImport("Greeter")
        greeterTest = new SwiftGreeterTest("GreeterTest", greeter).withImport("Greeter")
        multiplyTest = new SwiftMultiplyTest("GreeterTest", multiply).withTestableImport("Greeter")
    }

    List<XCTestSourceFileElement> getTestSuites() {
        return [sumTest, greeterTest, multiplyTest]
    }

    @Override
    List<SourceFile> getFiles() {
        return super.files
    }
}