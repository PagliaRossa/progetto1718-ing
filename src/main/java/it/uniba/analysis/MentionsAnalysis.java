package it.uniba.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import it.uniba.data.Counter;
import it.uniba.data.Mention;
import it.uniba.util.JSONReader;
import it.uniba.util.MentionUtil;
import it.uniba.util.ZipReader;
/**
 * Subclass of Analysis.
 * Analyzes Mentions of zipFile.
 *
 */
public class MentionsAnalysis extends Analysis {

	private final List<Mention> mentions = new ArrayList<>();

	/**
	 * Get List of Mentions.
	 * @return List of Mentions
	 */
	public List<Mention> getMentions() {
		return mentions;
	}

	private void removeWrongMentions() {
		final MentionUtil util = new MentionUtil();
		for (int i = 0; i < mentions.size(); i++) {
			if (util.getMentionFrom(mentions.get(i)) == null || util.getMentionTo(mentions.get(i)) == null) {
				mentions.remove(i);
				i--;
			} else if (util.mentionContain(util.getMentionTo(mentions.get(i)), "|")) {
				mentions.remove(i);
				i--;
			} else if (util.mentionContain(util.getMentionFrom(mentions.get(i)), util.getMentionTo(mentions.get(i)))) {
				mentions.remove(i);
				i--;
			} else if (util.mentionContain(util.getMentionTo(mentions.get(i)), "://")) {
				mentions.remove(i);
				i--;
			} else if (util.mentionStartWith(util.getMentionTo(mentions.get(i)), "cha")) {
				mentions.remove(i);
				i--;
			} else if (util.mentionContain(util.getMentionTo(mentions.get(i)), "everyone")) {
				mentions.remove(i);
				i--;
			}
		}
	}

	private List<Counter> removeOccurence() {
		final MentionUtil util = new MentionUtil();
		final List<Counter> counter = new ArrayList<>();
		for (int i = 0; i < mentions.size(); i++) {
			counter.add(util.newCounter(i, 1));
			for (int j = i + 1; j < mentions.size(); j++) {
				if (util.compareFrom(util.getMentionFrom(mentions.get(i)),
						util.getMentionFrom(mentions.get(j))) && util.compareTo(util.getMentionTo(mentions.get(i)),
								util.getMentionTo(mentions.get(j)))) {
					mentions.remove(j);
					j--;
					util.countIncreaser(counter.get(i));
				}
			}
		}
		return counter;
	}

	/**
	 * Set Name of 'From' and 'To' Mentions.
	 * @return List of Duplicated Counter Mentions
	 */
	public List<Counter> setNameFromTo() {
		final MentionUtil util = new MentionUtil();
		final List<Counter> counter = removeOccurence();
		Mention mention;
		for (int i = 0; i < mentions.size(); i++) {
			mention = mentions.get(i);
			util.setMentionFrom(mention, getMemberName(util.getMentionFrom(mention)));
			util.setMentionTo(mention, getMemberName(util.getMentionTo(mention)));
			mentions.set(i, mention);
		}
		return counter;
	}

	/**
	 * List of all Mentions in zipFile.
	 * @param input Path of zipFile
	 * @return Boolean of Accomplished (or not) Operation
	 */
	public boolean mentionsList(final String input) {
		final MentionUtil util = new MentionUtil();
		try {
			final ZipReader zip = new ZipReader();
			final JSONReader setter = new JSONReader();
			final List<String> conversations = zip.setConversationFile(input);
			for (int i = 0; i < util.conversationsSize(conversations); i++) {
				final String json = zip.getJSONFromFile(input, util.getConversationsJSON(conversations, i));
				mentions.addAll(setter.setMentions(json));
			}
			removeWrongMentions();
			return true;
		} catch (ParseException p) {
			System.out.println("JSON not valid!");
		} catch (IOException i) {
			System.out.println("File not found or invalid");
		}
		return false;
	}

	/**
	 * List of all Mentions in Specific Channels in zipFile.
	 * @param channel Name of Specific Channel
	 * @param path Path of zipFile
	 * @return Boolean of Accomplished (or not) Operation
	 */
	public boolean mentionsListChannel(final String channel, final String path) {
		final MentionUtil util = new MentionUtil();
		final ChannelsAnalysis analysis = new ChannelsAnalysis();
		try {
			if (analysis.channelsList(path)) {
				if (analysis.channelExist(channel)) {
					final ZipReader zip = new ZipReader();
					final JSONReader setter = new JSONReader();
					final List<String> conversations = zip.setConversationFile(channel, path);
					for (int i = 0; i < util.conversationsSize(conversations); i++) {
						final String json = zip.getJSONFromFile(path, util.getConversationsJSON(conversations, i));
						mentions.addAll(setter.setMentions(json));
					}
					removeWrongMentions();
					return true;
				} else {
					System.out.println("Channel not found");
					return false;
				}
			} else {
				throw new IOException();
			}
		} catch (ParseException p) {
			System.out.println("JSON not valid!");
		} catch (IOException i) {
			System.out.println("");
		}
		return false;
	}
}
