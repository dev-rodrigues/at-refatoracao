package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter {
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {

		String html;
		try (BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath))) {

			String line = reader.readLine();
			StringBuilder stringBuilder = new StringBuilder();
			html = "";
			while (line != null) {
				stringBuilder.append(StringEscapeUtils.escapeHtml(line));
				stringBuilder.append("<br />");
				line = reader.readLine();
			}
		}
		return html;

    }

    public String getFilename() {
        return this.fullFilenameWithPath;
    }
}
