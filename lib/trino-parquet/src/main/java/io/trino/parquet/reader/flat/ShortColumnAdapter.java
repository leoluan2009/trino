/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.parquet.reader.flat;

import io.trino.spi.block.Block;
import io.trino.spi.block.ShortArrayBlock;

import java.util.Optional;

public class ShortColumnAdapter
        implements ColumnAdapter<short[]>
{
    public static final ShortColumnAdapter SHORT_ADAPTER = new ShortColumnAdapter();

    @Override
    public short[] createBuffer(int size)
    {
        return new short[size];
    }

    @Override
    public Block createNonNullBlock(short[] values)
    {
        return new ShortArrayBlock(values.length, Optional.empty(), values);
    }

    @Override
    public Block createNullableBlock(boolean[] nulls, short[] values)
    {
        return new ShortArrayBlock(values.length, Optional.of(nulls), values);
    }

    @Override
    public void copyValue(short[] source, int sourceIndex, short[] destination, int destinationIndex)
    {
        destination[destinationIndex] = source[sourceIndex];
    }
}
