package com.metis.android.template.model.header;

import java.util.Map;

/**
 * Provides a Map containing headers for requests
 */
public interface HeaderProvider {

    Map<String, String> getHeaders();
}
