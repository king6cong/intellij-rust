package org.rust.ide.surroundWith.expression

import org.rust.ide.surroundWith.RustSurrounderTestCaseBase
import org.rust.ide.surroundWith.expression.RustWithIfExpSurrounder

class RustWithIfExpSurrounderTest : RustSurrounderTestCaseBase(RustWithIfExpSurrounder()) {
    fun testSimple() {
        doTest(
            """
            fn main() {
                <selection>true</selection>
            }
            """
            ,
            """
            fn main() {
                if true {<caret>}
            }
            """
        )
    }
    fun testCall() {
        doTest(
            """
            fn func() -> bool {
                false
            }

            fn main() {
                <selection>func()</selection>
            }
            """
            ,
            """
            fn func() -> bool {
                false
            }

            fn main() {
                if func() {<caret>}
            }
            """
        )
    }

    fun testNumber() {
        doTestNotApplicable(
            """
            fn main() {
                <selection>1234</selection>
            }
            """
        )
    }

    fun testNumberCall() {
        doTestNotApplicable(
            """
            fn func() -> i32 {
                1234
            }

            fn main() {
                <selection>func()</selection>
            }
            """
        )
    }
}