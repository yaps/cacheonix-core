/*
 * Cacheonix Systems licenses this file to You under the LGPL 2.1
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
package org.cacheonix.impl.net.multicast.server;

import org.cacheonix.impl.net.cluster.ClusterProcessor;
import org.cacheonix.impl.net.processor.Frame;

/**
 * Listener for multicast messages received by the multicast server.
 * <p/>
 *
 * @author <a href="mailto:simeshev@cacheonix.org">Slava Imeshev</a>
 * @see MulticastServerImpl#addListener(MulticastServerListener)
 * @see ClusterProcessor#startup()
 * @since Mar 29, 2008 11:14:44 AM
 */
public interface MulticastServerListener {

   /**
    * This method is called by {@link MulticastServerImpl} upon receipt of a multicast frame.
    *
    * @param frame received frame.
    */
   void receiveFrame(final Frame frame);
}
