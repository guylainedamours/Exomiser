/*
 * The Exomiser - A tool to annotate and prioritize genomic variants
 *
 * Copyright (c) 2016-2018 Queen Mary University of London.
 * Copyright (c) 2012-2016 Charité Universitätsmedizin Berlin and Genome Research Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.monarchinitiative.exomiser.autoconfigure.genome;

import de.charite.compbio.jannovar.data.JannovarData;
import org.junit.Test;
import org.monarchinitiative.exomiser.autoconfigure.ExomiserAutoConfigurationException;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Jules Jacobsen <j.jacobsen@qmul.ac.uk>
 */
public class JannovarDataSourceLoaderTest {

    @Test
    public void loadsData() {
        Path jannovarDataPath = Paths.get("src/test/resources/data/1710_hg19/1710_hg19_transcripts_ensembl.ser");
        JannovarData jannovarData = JannovarDataSourceLoader.loadJannovarData(jannovarDataPath);
        assertThat(jannovarData, instanceOf(JannovarData.class) );
    }

    @Test(expected = ExomiserAutoConfigurationException.class)
    public void cannotLoadData() {
        Path jannovarDataPath = Paths.get("src/test/resources/data/1710_hg19/wibble.ser");
        JannovarDataSourceLoader.loadJannovarData(jannovarDataPath);
    }
}