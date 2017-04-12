package org.jenkinsci.plugins.autocompleteparameter.providers;

import java.util.Arrays;
import java.util.Collection;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.model.Descriptor;

public class SimpleTextProvider extends AutocompleteDataProvider {
	private String autoCompleteData;
	
	@DataBoundConstructor
	public SimpleTextProvider(String autoCompleteData) {
		this.autoCompleteData = autoCompleteData;
	}

	@Override
	public Collection<?> getData() {
		return Arrays.asList(autoCompleteData.split("\n"));
	}
	
	@Extension
	public static final class DescriptorImpl extends Descriptor<AutocompleteDataProvider> {
		@Override
		public String getDisplayName() {
			return "List of text values";
		}
	}
}
