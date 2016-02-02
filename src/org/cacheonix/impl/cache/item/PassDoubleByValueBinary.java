/*
 * Cacheonix systems licenses this file to You under the LGPL 2.1
 * (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.cacheonix.org/products/cacheonix/license-lgpl-2.1.htm
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cacheonix.impl.cache.item;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.cacheonix.impl.net.serializer.Wireable;
import org.cacheonix.impl.net.serializer.WireableBuilder;

/**
 * Item that holds a object passsed by copy.
 *
 * @noinspection NonFinalFieldReferenceInEquals, NonFinalFieldReferenceInEquals, NonFinalFieldReferenceInEquals,
 * NonFinalFieldReferenceInEquals, NonFinalFieldReferencedInHashCode, NonFinalFieldReferencedInHashCode
 */
public final class PassDoubleByValueBinary implements Binary {

   /**
    * Builder used by WireableFactory.
    */
   public static final WireableBuilder BUILDER = new Builder();

   private static final long serialVersionUID = 0L;

   private double value;


   public PassDoubleByValueBinary() {

   }


   /**
    * Constructor.
    *
    * @param object to wrap.
    * @noinspection PublicConstructorInNonPublicClass
    */
   public PassDoubleByValueBinary(final double object) {

      this.value = object;
   }


   /**
    * {@inheritDoc}
    */
   public Object getValue() {

      return value;
   }


   public int getWireableType() {

      return TYPE_PASS_BY_VALUE_DOUBLE_BINARY;
   }


   public void writeWire(final DataOutputStream out) throws IOException {

      out.writeDouble(value);
   }


   public void readWire(final DataInputStream in) throws IOException {

      value = in.readDouble();
   }


   /**
    * {@inheritDoc}
    */
   public void writeExternal(final ObjectOutput out) throws IOException {

      out.writeDouble(value);
   }


   /**
    * {@inheritDoc}
    */
   public void readExternal(final ObjectInput in) throws IOException {

      value = in.readDouble();
   }


   public boolean equals(final Object o) {

      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }

      final PassDoubleByValueBinary that = (PassDoubleByValueBinary) o;

      return Double.compare(that.value, value) == 0;

   }


   public int hashCode() {

      final long temp = Double.doubleToLongBits(value);
      return (int) (temp ^ temp >>> 32);
   }


   public String toString() {

      return "PassDoubleByReferenceBinary{" +
              "value=" + value +
              '}';
   }


   static final class Builder implements WireableBuilder {

      public Wireable create() {

         return new PassDoubleByValueBinary();
      }
   }
}
