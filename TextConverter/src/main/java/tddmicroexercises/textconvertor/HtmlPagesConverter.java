package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlPagesConverter {

    private final String filename;
    private final List<Integer> breaks = new ArrayList<>();

    public HtmlPagesConverter(String filename) throws IOException {
        this.filename = filename;

        this.breaks.add(0);
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filename))) {
            int cumulativeCharCount = 0;
            String line = reader.readLine();
            while (line != null) {
                cumulativeCharCount += line.length() + 1; // add one for the newline
                if (line.contains("PAGE_BREAK")) {
                    int cumulative = cumulativeCharCount;
                    breaks.add(cumulative);
                }
                line = reader.readLine();
            }
        }
    }

    public String getHtmlPage(int page) throws IOException {
        StringBuilder htmlPage;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filename))) {
            reader.skip(breaks.get(page));
            htmlPage = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                if (line.contains("PAGE_BREAK")) {
                    break;
                }
                htmlPage.append(StringEscapeUtils.escapeHtml(line));
                htmlPage.append("<br />");

                line = reader.readLine();
            }
        }
        return htmlPage.toString();
    }

    public String getFilename() {
        return this.filename;
    }

}
